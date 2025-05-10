package event;

import console.Operator;
import event.contract.CLIEvent;

import java.util.List;

// besser custom events
public class CLIEventImpl implements CLIEvent {
    private final List<String> arguments;
    private Operator operator;

    public CLIEventImpl(List<String> arguments, Operator operator) {
        if (arguments == null || operator == null) throw new NullPointerException("Eines der Argumente ist null");
        this.arguments = arguments;
        this.operator = operator;
    }

    public List<String> getArguments() {
        return arguments;
    }
}
