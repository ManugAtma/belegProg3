import automat.*;
import kuchen.Allergen;
import observe.contract.Observer;
import observer.ObserverAllergene;
import observer.ObserverKapazitaet;
import verwaltung.Hersteller;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       /* Automat a = new Automat(3);

        a.addHersteller(new HerstellerImpl("Monte"));
        a.addHersteller(new HerstellerImpl("Ben"));
        a.addHersteller(new HerstellerImpl("DrOetker"));

        Hersteller droetker = new HerstellerImpl("DrOetker");
        ObsttorteImpl obsttorte = new ObsttorteImpl(
                new BigDecimal("6.00"),
                droetker, List.of(Allergen.Sesamsamen),
                400, Duration.ofDays(3),
                "Schoko", "Kirsche"
        );

        Hersteller ben = new HerstellerImpl("Ben");
        ObstkuchenImpl obstkuchen = new ObstkuchenImpl(
                new BigDecimal("5.20"),
                ben, List.of(Allergen.Haselnuss),
                280, Duration.ofDays(2),
                "Erdbeere"
        );

        Hersteller monte = new HerstellerImpl("Monte");
        KremkuchenImpl kremkuchen = new KremkuchenImpl(
                new BigDecimal("4.50"),
                monte, List.of(Allergen.Erdnuss),
                350, Duration.ofDays(4),
                "Vanille"
        );

        KremkuchenImpl kremkuchen2 = new KremkuchenImpl(
                new BigDecimal("4.50"),
                new HerstellerImpl("JA"),
                List.of(Allergen.Erdnuss), 350,
                Duration.ofDays(4), "Vanille"
        );

        a.addKuchen(obstkuchen);
        a.addKuchen(kremkuchen);
        System.out.println("Kuchen erfolgreich eingefuegt: " + a.addKuchen(kremkuchen2));
        a.addKuchen(obsttorte);
        System.out.println();

        System.out.println("alle Hersteller mit Anzahl der Kuchen:");
        for (Map.Entry<Hersteller, Integer> h: a.getAlleHersteller()){
            System.out.println(h.getKey().getName() + ": " + h.getValue());
        }
        System.out.println();

        System.out.println("Alle Kuchen:");
        for (AbstractKuchen ak: a.getAlleKuchenList()){
            System.out.println(ak);
        }
        System.out.println();

        System.out.println("vorhandene Allergene:");
        for (Allergen allergen : a.getVorhandeneAllergeneList()){
            System.out.println(allergen);
        }
        System.out.println();

        System.out.println("nicht vorhandene Allergene:");
        for (Allergen allergen : a.getNichtVorhandeneAllergeneList()){
            System.out.println(allergen);
        }
        System.out.println();

        System.out.println("remove kuchen at fach 0");
        a.removeKuchen(0);
        System.out.println();

        System.out.println("Alle Kuchen:");
        for (AbstractKuchen ak: a.getAlleKuchenList()){
            System.out.println(ak);
        }
        System.out.println();

        System.out.println("vorhandene Allergene:");
        for (Allergen allergen : a.getVorhandeneAllergeneList()){
            System.out.println(allergen);
        }
        System.out.println();

        System.out.println("nicht vorhandene Allergene:");
        for (Allergen allergen : a.getNichtVorhandeneAllergeneList()){
            System.out.println(allergen);
        }
        System.out.println();

        System.out.println("Ergebnisse von removeHersteller");
        Hersteller her1 = a.removeHersteller(new HerstellerImpl("Monte"));
        System.out.println(her1 == null ? "null" : her1.getName());
        Hersteller her2 = a.removeHersteller(new HerstellerImpl("JA"));
        System.out.println(her2 == null ? "null" : her2.getName());
        System.out.println();



        System.out.println("alle Hersteller mit Anzahl der Kuchen:");
        for (Map.Entry<Hersteller, Integer> h: a.getAlleHersteller()){
            System.out.println(h.getKey().getName() + ": " + h.getValue());
        }
        System.out.println();

        BigDecimal bd = new BigDecimal(-111);
        Duration du = Duration.ofDays(-4);
        System.out.println(du);

        System.out.println(new HerstellerImpl("h").hashCode());

        System.out.println("Test leeren Automat:");
        Automat a2 = new Automat(1);
        List<AbstractKuchen> akl = a2.getAlleKuchenList();
        for (AbstractKuchen k: akl){
            System.out.println(k.getEinfuegedatum());
        }

        Kuchen obsttorte2;

        System.out.println(obsttorte.getClass().getName());*/

      /*  String input = "  Kremkuchen Alice 4,50 386 36 Gluten,Erdnuss Butter";
        String s = input.trim();
        System.out.println(input);
        System.out.println(s);*/

       /* double d;
        String preis = "4,50";
        String inputWithDot = preis.replace(',', '.');
        System.out.println(inputWithDot);
        try {
            d = Double.parseDouble(inputWithDot);
        } catch (NumberFormatException e) {
            System.out.println("preis must be a real number");
        }

        double x = 4.50;*/

       /* String input = "Hel6o.World,Test";

        if (input.matches("[a-zA-Z.,]+")) {
            System.out.println("Valid input");
        } else {
            System.out.println("Invalid input");
        }*/

        /*String input = "         ";


        String[] arguments = input.trim().split("\\s+");

        System.out.println(arguments.length);*/

       /* Automat a = new Automat(5);

        Hersteller monte = new HerstellerImpl("Monte");
        KremkuchenImpl kremkuchen = new KremkuchenImpl(
                new BigDecimal("4.50"),
                monte, List.of(Allergen.Erdnuss),
                350, Duration.ofDays(4),
                "Vanille"
        );
        Hersteller ben = new HerstellerImpl("Ben");
        ObstkuchenImpl obstkuchen = new ObstkuchenImpl(
                new BigDecimal("5.20"),
                ben, List.of(Allergen.Haselnuss),
                280, Duration.ofDays(2),
                "Erdbeere"
        );*/

       /* Observer o = new ObserverKapazitaet(a);
        a.addObserver(o);

        Observer o2 = new ObserverAllergene(a);
        a.addObserver(o2);

        a.addHersteller(monte);
        a.addHersteller(ben);

        a.addKuchen(kremkuchen);
        a.addKuchen(obstkuchen);

        a.removeKuchen(0);
        a.removeKuchen(1);

        for (int i = 0; i<5; i++){
            a.addKuchen(kremkuchen);
        }

        ObstkuchenImpl copy = obstkuchen;*/

        Collection<Allergen> allergens = new ArrayList<>();
        allergens.add(Allergen.Erdnuss);
        System.out.println(allergens);
    }
}
