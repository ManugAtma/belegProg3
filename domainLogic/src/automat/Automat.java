package automat;

import kuchen.Allergen;
import observe.ObservableAutomat;
import observe.Observer;
import verwaltung.Hersteller;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


// TODO add override annotation after defining methods in interface
// TODO use kuchenType functionality?
public class Automat implements ObservableAutomat {

    private final int kapazitaet;
    private final Map<Integer, AbstractKuchen> kuchenByFach;
    private final Map<Hersteller, Integer> hersteller
            = new ConcurrentHashMap<>();
    private final Map<Allergen, Integer> allergene
            = new ConcurrentHashMap<>(Allergen.values().length);
    private final List<Observer> observer;


    public Automat(int kapazitaet) {
        if (kapazitaet < 1) throw new IllegalArgumentException("Kapazitaet < 1 ist unzulaessig.");
        this.kapazitaet = kapazitaet;
        kuchenByFach = new ConcurrentHashMap<>(kapazitaet);
        for (Allergen a : Allergen.values()) {
            allergene.put(a, 0);
        }
        this.observer = Collections.synchronizedList(new ArrayList<>());
    }

    public synchronized void addObserver(Observer observer) {
        if (observer == null) throw new NullPointerException("observer is null");
        this.observer.add(observer);
    }

    public synchronized void removeObserver(Observer observer) {
        if (observer == null) throw new NullPointerException("observer is null");
        this.observer.remove(observer);
    }

    private void notifyObservers() {
        for (Observer o : observer) {
            o.update();
        }
    }

    public synchronized boolean addKuchen(String type, BigDecimal preis, Hersteller hersteller, Collection<Allergen> allergene,
                                          int naehrwert, Duration haltbarkeit, String sorte1, String sorte2) {

        if (type == null || preis == null || hersteller == null
                || allergene == null || haltbarkeit == null
                || sorte1 == null) throw new NullPointerException("an arguments is null");

        if (!this.hersteller.containsKey(hersteller) || kuchenByFach.size() >= kapazitaet) return false;

        AbstractKuchen kuchen = switch (type) {
            case "Kremkuchen" -> new KremkuchenImpl(preis, hersteller, allergene, naehrwert, haltbarkeit, sorte1);
            case "Obstkuchen" -> new ObstkuchenImpl(preis, hersteller, allergene, naehrwert, haltbarkeit, sorte1);
            case "Obsttorte" -> new ObsttorteImpl(preis, hersteller, allergene, naehrwert, haltbarkeit, sorte1, sorte2);
            default -> null;
        };
        if (kuchen == null) throw new IllegalArgumentException("kuchen type not supported");

        boolean success = false;
        int i = 0;
        while (i < kapazitaet && !success) {
            if (kuchenByFach.get(i) == null) {
                kuchenByFach.put(i, kuchen);
                this.hersteller.put(hersteller, this.hersteller.get(hersteller) + 1);
                this.incrementAllergene(kuchen);
                kuchen.setFachnummer(i);
                kuchen.setEinfuegedatum(new Date());
                this.notifyObservers();
                success = true;
            }
            i++;
        }
        System.out.println("MODEL: Kuchen added");
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

    public synchronized AbstractKuchen removeKuchen(int input) {
        if (input < 0) throw new IllegalArgumentException("Ungueltige Fachnummer");
        int fachnummer = input - 1;
        AbstractKuchen result = kuchenByFach.get(fachnummer); // is null if fachnummer > kapazitaet
        kuchenByFach.remove(fachnummer);
        this.decrementAllergene(result);
        this.notifyObservers();
        System.out.println("MODEL: Kuchen removed:" + result);
        return result;
    }


    /**
     * Gets a List of all Kuchen or only of specified type
     *
     * @param type         the interface type of the Kuchen, so without "Impl"
     * @param filterByType true if kuchen should be filtered by type, false otherwise
     * @return List of all Kuchen or only of specified type
     * @throws NullPointerException,IllegalArgumentException when type is null or empty
     */
    public List<AbstractKuchen> getAlleKuchen(String type, boolean filterByType) {

        if (!filterByType) return List.copyOf(kuchenByFach.values());

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

   /* public List<AbstractKuchen> getAlleKuchenList() {
        Collection<AbstractKuchen> col = kuchenByFach.values();
        List<AbstractKuchen> list = new ArrayList<>();
        for (AbstractKuchen k : col) {
            if (k != null) list.add(k);
        }
        return list;
    }*/

    /*public Map<Integer, AbstractKuchen> getAlleKuchenMap() {
        return new HashMap<>(kuchenByFach);
    }*/

    @Override
    public int getNumberOfKuchen() {
        return kuchenByFach.size();
    }

    public synchronized boolean addHersteller(Hersteller h) {
        if (h == null) throw new NullPointerException("Hersteller ist null");
        if (hersteller.containsKey(h)) return false;
        else {
            hersteller.put(h, 0);
            System.out.println("MODEL: Hersteller added");
        }
        return true;
    }

    public synchronized Hersteller removeHersteller(String name) {
        if (name == null) throw new NullPointerException("name is null");
        Hersteller newHersteller = new HerstellerImpl(name);
        Hersteller result = hersteller.containsKey(newHersteller) ? newHersteller : null;
        hersteller.remove(newHersteller);
        System.out.println("MODEL: Hersteller removed: " + result);
        return result;
    }

    public Set<Map.Entry<Hersteller, Integer>> getAlleHersteller() {
        return new HashMap<>(hersteller).entrySet();
    }

    @Override
    public List<Allergen> getVorhandeneAllergeneList() {
        List<Allergen> vorhandeAllergene = new ArrayList<>();
        for (Allergen a : Allergen.values()) {
            if (allergene.get(a) > 0) vorhandeAllergene.add(a);
        }
        return vorhandeAllergene;
    }

    @Override
    public List<Allergen> getNichtVorhandeneAllergeneList() {
        List<Allergen> nichtVorhandeAllergene = new ArrayList<>();
        for (Allergen a : Allergen.values()) {
            if (allergene.get(a) == 0) nichtVorhandeAllergene.add(a);
        }
        return nichtVorhandeAllergene;
    }

    /**
     * Returns a Map which maps an Allergen to its number of occurrences
     *
     * @return Map which is always of size 4
     */
    public Map<Allergen, Integer> getAlleAllergeneMap() {
        return new EnumMap<>(this.allergene);
    }

    public synchronized boolean setInspektionsdatum(int fachnummer, Date datum) {
        if (datum == null) throw new NullPointerException("datum ist null");
        if (kuchenByFach.get(fachnummer) == null) return false;
        kuchenByFach.get(fachnummer).setInspektionsdatum(datum);
        System.out.println("MODEL: Inspektionsdatum set");
        return true;
    }

    @Override
    public int getKapazitaet() {
        return kapazitaet;
    }
}

