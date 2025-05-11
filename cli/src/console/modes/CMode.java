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

public class CMode extends AbstractInputMode {

    @Override
    public Command parseCommand(String input) {

        if (input.trim().isEmpty()) return null;

        String[] args = input.trim().split("\\s+");
        if (args.length == 1) return parseAddHersteller(args[0]);
        return parseAddKuchen(args);
    }

    private Command parseAddHersteller(String arg) {

        String name = this.parseLetterOnlyString(arg, "hersteller");
        if (name == null) return null; // arg contains non letter char

        Hersteller hersteller = new HerstellerImpl(name);
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

        Integer naerhwert = this.parseStringToPositiveInt(args[3], "naehrwert");
        if (naerhwert == null) return null;

        Duration haltbarkeit;
        Integer i = this.parseStringToPositiveInt(args[4], "haltbarkeit");
        if (i == null) return null;
        else haltbarkeit = Duration.ofDays(i);

        Collection<Allergen> allergene = this.parseAllergene(args[5]);
        if (allergene == null) return null;

        String sorte1 = this.parseLetterOnlyString(args[6], "kremsorte or obstsorte"); // obstsorte or kremsorte
        if (sorte1 == null) return null;

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
                String obstsorte = this.parseLetterOnlyString(args[7], "obstsorte");
                if (obstsorte == null) return null;

                kuchen = new ObsttorteImpl(
                        preis, hersteller, allergene,
                        naerhwert, haltbarkeit, sorte1, obstsorte
                );
                break;
            default:
                System.out.println("something went wrong");
        }

        CLIEvent event = new AddKuchenEvent(kuchen);
        return new Command(Operator.ADD_KUCHEN, event);
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
