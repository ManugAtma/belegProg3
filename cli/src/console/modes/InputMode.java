package console.modes;

import console.Command;

public interface InputMode {
    Command parseCommand(String input);
}
