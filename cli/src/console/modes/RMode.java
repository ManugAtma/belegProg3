package console.modes;

import console.Command;
import console.Operator;
import console.contract.InputMode;
import event.contract.CLIEvent;
import event.events.GetAllergeneEvent;
import event.events.GetHerstellerEvent;
import event.events.GetKuchenEvent;

public class RMode implements InputMode {

    @Override
    public Command parseCommand(String input) {

        String[] args = input.trim().split("\\s+");

        switch (args[0]) {
            case "hersteller":
                return this.parseHersteller(args);
            case "kuchen":
                return this.parseKuchen(args);
            case "allergene":
                return this.parseAllergene(args);
        }
        System.out.println("invalid command");
        return null;
    }

    private Command parseHersteller(String[] args) {
        if (args.length != 1) {
            System.out.println("hersteller command cannot have arguments");
            return null;
        }
        return new Command(Operator.GET_HERSTELLER, new GetHerstellerEvent());
    }

    private Command parseKuchen(String[] args) {
        CLIEvent event;
        switch (args.length) {
            case 1:
                event = new GetKuchenEvent(null);
                break;
            case 2:
                if (!InputMode.getKuchenTypes().containsKey(args[1])) {
                    System.out.println("no such kuchen type");
                    return null;
                }
                event = new GetKuchenEvent(args[1]);
                break;
            default:
                System.out.println("kuchen command cannot have more than 1 arguments");
                return null;
        }
        return new Command(Operator.GET_KUCHEN, event);
    }

    private Command parseAllergene(String[] args) {
        if (args.length != 2) {
            System.out.println("allergene command must have exactly 1 argument");
            return null;
        }
        CLIEvent event;

        switch (args[1]) {
            case "i":
                event = new GetAllergeneEvent(true);
                break;
            case "e":
                event = new GetAllergeneEvent(false);
                break;
            default:
                System.out.println("argument can only be 'i' or 'e'");
                return null;
        }
        return new Command(Operator.GET_ALLERGENE, event);
    }
}
