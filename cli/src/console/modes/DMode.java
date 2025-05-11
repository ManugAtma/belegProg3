package console.modes;

import console.Command;
import console.Operator;
import console.contract.InputMode;
import event.contract.CLIEvent;
import event.events.RemoveHerstellerEvent;
import event.events.RemoveKuchenEvent;

public class DMode extends AbstractInputMode {

    @Override
    public Command parseCommand(String input) {

        if (input.trim().isEmpty()) return null;

        String[] args = input.trim().split("\\s+");

        if (args.length > 1) {
            System.out.println("commands in read mode cannot have arguments");
            return null;
        }

        if (Character.isLetter(args[0].charAt(0))) return this.parseHersteller(args[0]);
        return this.parseFachnummer(args[0]);
    }

    private Command parseHersteller(String arg) {

        if (this.parseLetterOnlyString(arg, "hersteller") == null) return null;

        CLIEvent event = new RemoveHerstellerEvent(arg);
        return new Command(Operator.REMOVE_HERSTELLER, event);
    }

    private Command parseFachnummer(String arg) {
        Integer i = this.parseStringToPositiveInt(arg, "fachnummer");
        if (i == null) return null;

        CLIEvent event = new RemoveKuchenEvent(i);
        return new Command(Operator.REMOVE_KUCHEN, event);
    }
}
