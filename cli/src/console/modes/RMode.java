package console.modes;

import console.Operator;
import console.contract.InputMode;
import event.cli.events.GetAllergeneEvent;
import event.cli.events.GetHerstellerEvent;
import event.cli.events.GetKuchenEvent;

public class RMode extends AbstractInputMode {
    private GetAllergeneEvent getAllergeneEvent;
    private GetHerstellerEvent getHerstellerEvent;
    private GetKuchenEvent getKuchenEvent;


    @Override
    public Operator parse(String input) {

        if (input.trim().isEmpty()) return null;

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

    private Operator parseHersteller(String[] args) {
        if (args.length != 1) {
            System.out.println("hersteller command cannot have arguments");
            return null;
        }
        this.getHerstellerEvent = new GetHerstellerEvent();
        return Operator.GET_HERSTELLER;
    }

    private Operator parseKuchen(String[] args) {
        GetKuchenEvent event;
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
        this.getKuchenEvent = event;
        return Operator.GET_KUCHEN;
    }

    private Operator parseAllergene(String[] args) {
        if (args.length != 2) {
            System.out.println("allergene command must have exactly 1 argument");
            return null;
        }
        GetAllergeneEvent event;

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
        this.getAllergeneEvent = event;
        return Operator.GET_ALLERGENE;
    }

    public GetAllergeneEvent getGetAllergeneEvent() {
        return getAllergeneEvent;
    }

    public GetHerstellerEvent getGetHerstellerEvent() {
        return getHerstellerEvent;
    }

    public GetKuchenEvent getGetKuchenEvent() {
        return getKuchenEvent;
    }
}
