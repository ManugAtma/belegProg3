package console.modes;

import console.Operator;
import event.cli.events.RemoveHerstellerEvent;
import event.cli.events.RemoveKuchenEvent;

public class DMode extends AbstractInputMode {
    private RemoveHerstellerEvent removeHerstellerEvent;
    private RemoveKuchenEvent removeKuchenEvent;

    @Override
    public Operator parse(String input) {

        if (input.trim().isEmpty()) return null;

        String[] args = input.trim().split("\\s+");

        if (args.length > 1) {
            System.out.println("commands in read mode cannot have arguments");
            return null;
        }

        if (Character.isLetter(args[0].charAt(0))) return this.parseHersteller(args[0]);
        return this.parseFachnummer(args[0]);
    }

    private Operator parseHersteller(String arg) {

        if (this.parseLetterOnlyString(arg, "hersteller") == null) return null;

        RemoveHerstellerEvent event = new RemoveHerstellerEvent(arg);
        this.removeHerstellerEvent = event;
        return Operator.REMOVE_HERSTELLER;
    }

    private Operator parseFachnummer(String arg) {
        Integer i = this.parseStringToPositiveInt(arg, "fachnummer");
        if (i == null) return null;

        RemoveKuchenEvent event = new RemoveKuchenEvent(i);
        this.removeKuchenEvent = event;
        return Operator.REMOVE_KUCHEN;
    }

    public RemoveHerstellerEvent getRemoveHerstellerEvent() {
        return removeHerstellerEvent;
    }

    public RemoveKuchenEvent getRemoveKuchenEvent() {
        return removeKuchenEvent;
    }
}
