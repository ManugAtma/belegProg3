import automat.*;
import kuchen.Allergen;
import verwaltung.Hersteller;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Automat a = new Automat(3);

        a.addHersteller(new HerstellerImpl("Monte"));
        a.addHersteller(new HerstellerImpl("Ben"));
        a.addHersteller(new HerstellerImpl("DrOetker"));

        Hersteller droetker = new HerstellerImpl("DrOetker");
        ObsttorteImpl obsttorte = new ObsttorteImpl(
                new BigDecimal("6.00"),
                3, // Fachnummer
                droetker,
                List.of(Allergen.Sesamsamen),
                400,
                Duration.ofDays(3),
                "Schoko",
                "Kirsche"
        );

        Hersteller ben = new HerstellerImpl("Ben");
        ObstkuchenImpl obstkuchen = new ObstkuchenImpl(
                new BigDecimal("5.20"),
                2, // Fachnummer
                ben,
                List.of(Allergen.Haselnuss),
                280,
                Duration.ofDays(2),
                "Erdbeere"
        );

        Hersteller monte = new HerstellerImpl("Monte");
        KremkuchenImpl kremkuchen = new KremkuchenImpl(
                new BigDecimal("4.50"),
                // aktuelles Datum
                1, // Fachnummer
                monte,
                List.of(Allergen.Erdnuss),
                350, // Nährwert
                Duration.ofDays(4),
                "Vanille"
        );

        KremkuchenImpl kremkuchen2 = new KremkuchenImpl(
                new BigDecimal("4.50"),
                // aktuelles Datum
                1, // Fachnummer
                new HerstellerImpl("JA"),
                List.of(Allergen.Erdnuss),
                350, // Nährwert
                Duration.ofDays(4),
                "Vanille"
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
        for (AbstractKuchen ak: a.getAlleKuchen()){
            System.out.println(ak);
        }
        System.out.println();

        System.out.println("vorhandene Allergene:");
        for (Allergen allergen : a.getVorhandeneAllergene()){
            System.out.println(allergen);
        }
        System.out.println();

        System.out.println("nicht vorhandene Allergene:");
        for (Allergen allergen : a.getNichtVorhandeneAllergene()){
            System.out.println(allergen);
        }
        System.out.println();

        System.out.println("remove kuchen at fach 0");
        a.removeKuchen(0);
        System.out.println();

        System.out.println("Alle Kuchen:");
        for (AbstractKuchen ak: a.getAlleKuchen()){
            System.out.println(ak);
        }
        System.out.println();

        System.out.println("vorhandene Allergene:");
        for (Allergen allergen : a.getVorhandeneAllergene()){
            System.out.println(allergen);
        }
        System.out.println();

        System.out.println("nicht vorhandene Allergene:");
        for (Allergen allergen : a.getNichtVorhandeneAllergene()){
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
    }
}
