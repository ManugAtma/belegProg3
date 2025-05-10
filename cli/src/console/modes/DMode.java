package console.modes;

import console.Command;
import console.Operator;
import console.contract.InputMode;
import event.contract.CLIEvent;
import event.events.RemoveHerstellerEvent;
import event.events.RemoveKuchenEvent;

public class DMode implements InputMode {

    @Override
    public Command parseCommand(String input) {

        if (input.trim().isEmpty()) {
            System.out.println("invalid command");
            return null;
        }

        String[] args = input.trim().split("\\s+");

        if (args.length > 1) {
            System.out.println("commands in read mode cannot have arguments");
            return null;
        }

        if (args[0].matches("[a-zA-Z,]+")) return this.parseHersteller(args[0]);
        return this.parseFachnummer(args[0]);
    }

    public Command parseHersteller(String arg) {
        CLIEvent event = new RemoveHerstellerEvent(arg);
        return new Command(Operator.REMOVE_HERSTELLER, event);
    }

    public Command parseFachnummer(String arg) {
        int i;
        try {
            i = Integer.parseInt(arg);
        } catch (NumberFormatException e) {
            System.out.println("fachnummer must be an integer");
            return null;
        }
        CLIEvent event = new RemoveKuchenEvent(i);
        return new Command(Operator.REMOVE_KUCHEN, event);
    }
}
