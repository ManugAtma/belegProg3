package console.modes;

import automat.*;
import console.Command;
import console.Operator;
import console.contract.InputMode;
import event.contract.CLIEvent;
import event.events.AddHerstellerEvent;
import event.events.AddKuchenEvent;
import kuchen.Allergen;
import verwaltung.Hersteller;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class CMode implements InputMode {

    @Override
    public Command parseCommand(String input) {

        String[] args = input.trim().split("\\s+");
        if (args.length == 1) return parseAddHersteller(args[0]);
        return parseAddKuchen(args);
    }

    private Command parseAddHersteller(String arg) {

        if (!arg.matches("[a-zA-Z,]+")) {
            System.out.println("hersteller name can only contain letters and commas and must not be empty");
            return null;
        }
        Hersteller hersteller = new HerstellerImpl(arg);
        CLIEvent event = new AddHerstellerEvent(hersteller);
        return new Command(Operator.ADD_HERSTELLER, event);
    }


    private Command parseAddKuchen(String[] args) {

        Map<String, Integer> kuchenTypes = InputMode.getKuchenTypes();
        Integer numOfAttributes = kuchenTypes.get(args[0]); // returns null if kuchen type is not available

        if (numOfAttributes == null) {
            System.out.println("no such kuchen type");
            return null;
        }

        if (numOfAttributes != args.length) {
            System.out.println("wrong number of arguments for kuchen type");
            return null;
        }

        Hersteller hersteller = new HerstellerImpl(args[1]);

        BigDecimal preis = this.parsePreis(args[2]);
        if (preis == null) return null;

        Integer naerhwert = this.parseStringToInt(args[3], "naehrwert");
        if (naerhwert == null) return null;

        Duration haltbarkeit;
        Integer i = this.parseStringToInt(args[4], "haltbarkeit");
        if (i == null) return null;
        else haltbarkeit = Duration.ofDays(i);

        Collection<Allergen> allergene = this.parseAllergene(args[5]);
        if (allergene == null) return null;

        String sorte1 = args[6]; // obstsorte or kremsorte

        AbstractKuchen kuchen = null;
        switch (args[0]) {
            case "Kremkuchen":
                kuchen = new KremkuchenImpl(
                        preis, hersteller, allergene,
                        naerhwert, haltbarkeit, sorte1
                );
                break;
            case "Obstkuchen":
                kuchen = new ObstkuchenImpl(
                        preis, hersteller, allergene,
                        naerhwert, haltbarkeit, sorte1
                );
                break;
            case "Obsttorte":
                String sorte2 = args[7];
                kuchen = new ObsttorteImpl(
                        preis, hersteller, allergene,
                        naerhwert, haltbarkeit, sorte1, sorte2
                );
                break;
            default:
                System.out.println("something went wrong");
        }

        CLIEvent event = new AddKuchenEvent(kuchen);
        return new Command(Operator.ADD_KUCHEN, event);
    }


    private Integer parseStringToInt(String input, String arg) {
        int i;
        try {
            i = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println(arg + " must be an integer");
            return null;
        }
        if (i <= 0) {
            System.out.println(arg + " must be >0");
            return null;
        }
        return i;
    }

    private BigDecimal parsePreis(String input) {
        double d;
        String inputWithDot = input.replace(',', '.');
        try {
            d = Double.parseDouble(inputWithDot);
        } catch (NumberFormatException e) {
            System.out.println("preis must be a real number");
            return null;
        }
        if (d <= 0) {
            System.out.println("preis must be >0");
            return null;
        }
        return new BigDecimal(d);
    }

    private Collection<Allergen> parseAllergene(String input){
        Collection<Allergen> allergene = new ArrayList<>();
        for (String s: input.split(",")) {
            switch (s) {
                case "Gluten":
                    allergene.add(Allergen.Gluten);
                    break;
                case "Erdnuss":
                    allergene.add(Allergen.Erdnuss);
                    break;
                case "Haselnuss":
                    allergene.add(Allergen.Haselnuss);
                    break;
                case "Sesamsamen":
                    allergene.add(Allergen.Sesamsamen);
                    break;
                default:
                    System.out.println("Unknown allergen");
                    return null;
            }
        }
        return allergene;
    }
}
