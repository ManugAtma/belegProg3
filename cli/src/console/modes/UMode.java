package console.modes;

import console.Command;
import console.Operator;
import event.cli.contract.CLIEvent;
import event.cli.events.SetFachnummerEvent;

public class UMode extends AbstractInputMode {

    @Override
    public Command parseCommand(String input) {

        if (input.trim().isEmpty()) return null;

        Integer i = this.parseStringToPositiveInt(input, "fachnummer");
        if (i == null) return null;
        CLIEvent event = new SetFachnummerEvent(i);
        return new Command(Operator.SET_FACHNUMMER, event);
    }
}
