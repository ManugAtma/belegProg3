package automat;

import kuchen.Allergen;
import verwaltung.Hersteller;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Automat {

    private final int kapazitaet;
    private final Map<Integer, AbstractKuchen> kuchenByFach;
    private final Map<Hersteller, Integer> hersteller
            = new ConcurrentHashMap<>();
    private final Map<Allergen, Integer> allergene
            = new ConcurrentHashMap<>(Allergen.values().length);


    public Automat(int kapazitaet) {
        if (kapazitaet < 1) throw new IllegalArgumentException("Kapazitaet < 1 ist unzulaessig.");
        this.kapazitaet = kapazitaet;
        kuchenByFach = new ConcurrentHashMap<>(kapazitaet);
        for (Allergen a : Allergen.values()) {
            allergene.put(a, 0);
        }
    }

    // möglich auch kein Kuchenobjekt entgegenzunehmen, sondern infos als String, und dann
    // Kuchenobject selber bauen
    public synchronized boolean addKuchen(AbstractKuchen kuchen) {
        if (kuchen == null) throw new NullPointerException("kuchen is null");
        Hersteller dieserHersteller = kuchen.getHersteller();
        if (!hersteller.containsKey(dieserHersteller) || kuchenByFach.size() >= kapazitaet) return false;

        boolean success = false;
        int i = 0;
        while (i < kapazitaet && !success) {
            if (kuchenByFach.get(i) == null) {
                kuchenByFach.put(i, kuchen);
                hersteller.put(dieserHersteller, hersteller.get(dieserHersteller) + 1);
                this.incrementAllergene(kuchen);
                kuchen.setFachnummer(i);
                kuchen.setEinfuegedatum(new Date());
                success = true;
            }
            i++;
        }
        return success;
    }

    private void incrementAllergene(AbstractKuchen kuchen) {
        if (kuchen == null) return;
        for (Allergen a : kuchen.getAllergene()) {
            allergene.put(a, allergene.get(a) + 1);
        }
    }

    private void decrementAllergene(AbstractKuchen kuchen) {
        if (kuchen == null) return;
        for (Allergen a : kuchen.getAllergene()) {
            allergene.put(a, allergene.get(a) - 1);
        }
    }

    public synchronized AbstractKuchen removeKuchen(int fachnummer) {
        if (fachnummer >= kapazitaet || fachnummer < 0) throw new IllegalArgumentException("Ungueltige Fachnummer");
        AbstractKuchen result = kuchenByFach.get(fachnummer);
        kuchenByFach.remove(fachnummer);
        this.decrementAllergene(result);
        return result;
    }

    public List<AbstractKuchen> getAlleKuchenList() {
        Collection<AbstractKuchen> col = kuchenByFach.values();
        List<AbstractKuchen> list = new ArrayList<>();
        for (AbstractKuchen k : col) {
            if (k != null) list.add(k);
        }
        return list;
    }

    public Map<Integer, AbstractKuchen> getAlleKuchenMap() {
        return kuchenByFach;
    }

    /**
     * Gets a List of Kuchen by specified type
     * @param type the type of the Kuchen without the four last letters "Impl"
     * @return List of Kuchen by specified type
     * @throws NullPointerException,IllegalArgumentException when type is null or empty
     */
    public List<AbstractKuchen> getAlleKuchenOfType(String type) {
        if (type == null) throw new NullPointerException("type ist null");
        if (type.isEmpty()) throw new IllegalArgumentException("type ist empty");
        Collection<AbstractKuchen> col = kuchenByFach.values();
        List<AbstractKuchen> list = new ArrayList<>();
        for (AbstractKuchen k : col) {
            if (k != null && k.getClass().getSimpleName()
                        .substring(0, k.getClass().getSimpleName().length() - 4)
                        .equals(type)
            ) list.add(k);
        }
        return list;
    }


    public synchronized boolean addHersteller(Hersteller h) {
        if (h == null) throw new NullPointerException("Hersteller ist null");
        if (hersteller.containsKey(h)) return false;
        else hersteller.put(h, 0);
        return true;
    }

    public synchronized Hersteller removeHersteller(Hersteller h) {
        if (h == null) throw new NullPointerException("Hersteller ist null");
        Hersteller result = hersteller.containsKey(h) ? h : null;
        hersteller.remove(h);
        return result;
    }

    public Set<Map.Entry<Hersteller, Integer>> getAlleHersteller() {
        return hersteller.entrySet();
    }


    public List<Allergen> getVorhandeneAllergeneList() {
        List<Allergen> vorhandeAllergene = new ArrayList<>();
        for (Allergen a : Allergen.values()) {
            if (allergene.get(a) > 0) vorhandeAllergene.add(a);
        }
        return vorhandeAllergene;
    }

    public List<Allergen> getNichtVorhandeneAllergeneList() {
        List<Allergen> nichtVorhandeAllergene = new ArrayList<>();
        for (Allergen a : Allergen.values()) {
            if (allergene.get(a) == 0) nichtVorhandeAllergene.add(a);
        }
        return nichtVorhandeAllergene;
    }

    /**
     * Returns a Map which maps Allergen to its number of occurrences
     * @return Map which is always of size 4
     */
    public Map<Allergen, Integer> getAlleAllergeneMap() {
        return this.allergene;
    }

    public synchronized boolean setInspektionsdatum(int fachnummer, Date datum) {
        if (datum == null) throw new NullPointerException("datum ist null");
        if (kuchenByFach.get(fachnummer) == null) return false;
        kuchenByFach.get(fachnummer).setInspektionsdatum(datum);
        return true;
    }

    public int getKapazitaet() {
        return kapazitaet;
    }

}

