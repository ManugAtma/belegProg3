import kuchen.Allergen;
import kuchen.Kuchen;
import verwaltung.Hersteller;
import verwaltung.Verkaufsobjekt;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Automat<T extends Kuchen & Verkaufsobjekt> {

    private final int kapazitaet;
    private final Map<Integer, Fach> faecher;
    private final Map<Hersteller, Integer> hersteller
            = new ConcurrentHashMap<Hersteller, Integer>();
    private final Map<Allergen, Integer> allergene
            = new ConcurrentHashMap<Allergen, Integer>(Allergen.values().length);


    public Automat(int kapazitaet) {
        if (kapazitaet < 1) throw new IllegalArgumentException("Kapazitaet < 1 ist unzulaessig.");
        this.kapazitaet = kapazitaet;
        faecher = new ConcurrentHashMap<Integer, Fach>(kapazitaet);
        for (Allergen a : Allergen.values()) {
            allergene.put(a, 0);
        }
    }


    synchronized boolean addKuchen(T kuchen) {
        if (kuchen == null) throw new NullPointerException("kuchen is null");
        Hersteller dieserHersteller = kuchen.getHersteller();
        if (!hersteller.containsKey(dieserHersteller) || faecher.size() >= kapazitaet) return false;

        boolean success = false;
        int i = 0;
        while (i < kapazitaet && !success) {
            if (faecher.get(i) == null) {
                faecher.put(i, new Fach(kuchen));
                hersteller.put(dieserHersteller,hersteller.get(dieserHersteller) + 1);
                // kuchen.setFachnummer() nicht moeglich, da nicht in Interface Kuchen oder Verkaufsobject
                this.incrementAllergene(kuchen);
                success = true;
            }
            i++;
        }
        return success;
    }

    private void incrementAllergene(T kuchen){
        for (Allergen a : kuchen.getAllergene()){
            allergene.put(a, allergene.get(a) + 1);
        }
    }

    private void decrementAllergene(T kuchen){
        for (Allergen a : kuchen.getAllergene()){
            allergene.put(a, allergene.get(a) -1);
        }
    }

    synchronized T removeKuchen(int fachnummer) {
        if (fachnummer >= kapazitaet || fachnummer < 0) throw new IllegalArgumentException("Ungueltige Fachnummer");
        T result = faecher.get(fachnummer).kuchen;
        faecher.remove(fachnummer);
        this.decrementAllergene(result);
        return result;
    }

    List<T> getAlleKuchen() {
        Collection<Fach> col = faecher.values();
        List<T> list = new ArrayList<T>();
        for (Fach f : col) {
            if (f != null && f.kuchen != null) list.add(f.kuchen);
        }
        return list;
    }


    List<T> getAlleKuchen(Hersteller hersteller) {
        if (hersteller == null) throw new NullPointerException();
        Collection<Fach> col = faecher.values();
        List<T> list = new ArrayList<T>();
        for (Fach f : col) {
            if ( f != null
                    && f.kuchen != null
                    && f.kuchen.getHersteller().equals(hersteller)) list.add(f.kuchen);
        }
        return list;
    }


    synchronized boolean addHersteller(Hersteller h) {
        if (h == null) throw new NullPointerException("Hersteller ist null");
        if (hersteller.containsKey(h)) return false;
        else hersteller.put(h, 0);
        return true;
    }

    synchronized Hersteller removeHersteller(Hersteller h) {
        if (h == null) throw new NullPointerException("Hersteller ist null");
        Hersteller result = hersteller.containsKey(h) ? h : null;
        hersteller.remove(h);
        return result;
    }

    Set<Map.Entry<Hersteller, Integer>> getAlleHersteller() {
        return hersteller.entrySet();
    }

    List<Allergen> getVorhandeneAllergene() {
        List<Allergen> vorhandeAllergene = new ArrayList<>();
        for(Allergen a : Allergen.values()){
            if (allergene.get(a) > 0) vorhandeAllergene.add(a);
        }
        return vorhandeAllergene;
    }

    List<Allergen> getNichtVorhandeneAllergene() {
        List<Allergen> nichtVorhandeAllergene = new ArrayList<>();
        for(Allergen a : Allergen.values()){
            if (allergene.get(a) == 0) nichtVorhandeAllergene.add(a);
        }
        return nichtVorhandeAllergene;
    }

    synchronized void setInspektionsDatum(int fachnummer) {
        // faecher.get(fachnummer).kuchen.setInspektionsdatum()
        // geht wieder nicht
    }

    int getKapazitaet() {
        return kapazitaet;
    }

    private class Fach {
        private T kuchen;
        private Date einfuegedatum = new Date();

        // add getters and toString?

        Fach(T kuchen) {
            if (kuchen == null ) throw new NullPointerException("kuchen ist null");
            this.kuchen = kuchen;
        }
    }
}
