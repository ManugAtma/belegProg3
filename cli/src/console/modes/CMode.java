package console.modes;

import console.Command;

public class CMode implements InputMode {

    @Override
    public Command parseCommand(String input) {
        // if syntax is wrong, sysout + return null
        return null;
    }
}
