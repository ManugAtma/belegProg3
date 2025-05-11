package console.modes;

import console.Command;
import console.Operator;
import console.contract.InputMode;
import event.contract.CLIEvent;
import event.events.SetFachnummerEvent;

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
