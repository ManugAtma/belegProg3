package console.modes;

import console.Operator;
import event.cli.events.LoadEvent;
import event.cli.events.SaveEvent;

public class PMode extends AbstractInputMode {
    private LoadEvent loadEvent;
    private SaveEvent saveEvent;

    @Override
    public Operator parse(String input) {

        if (input.trim().isEmpty()) return null;

        String[] args = input.trim().split("\\s+");
        if (args.length != 2) {
            System.out.println("commands in persistence mode must have exactly one argument");
            return null;
        }

        if (args[0].equals("save")) return this.parseSave(args[1]);
        if (args[0].equals("load")) return this.parseLoad(args[1]);

        System.out.println("invalid command");
        return null;
    }

    private Operator parseSave(String arg) {
        Boolean b = this.parseSecondArgument(arg);
        if (b == null) return null;

        this.saveEvent = new SaveEvent(b);
        return Operator.SAVE;
    }

    private Operator parseLoad(String arg) {
        Boolean b = this.parseSecondArgument(arg);
        if (b == null) return null;

        this.loadEvent = new LoadEvent(b);
        return Operator.LOAD;
    }

    private Boolean parseSecondArgument(String arg) {
        switch (arg) {
            case "JOS":
                return true;
            case "JBP":
                return false;
            default:
                System.out.println("argument must be either JOS or JBP");
        }
        return null;
    }

    public LoadEvent getLoadEvent() {
        return loadEvent;
    }

    public SaveEvent getSaveEvent() {
        return saveEvent;
    }
}
