package console;

import event.cli.contract.CLIEvent;

public class Command {
    private Operator operator;
    private CLIEvent event;

    public Command(Operator operator, CLIEvent event) {
        if (operator == null || event == null) throw new NullPointerException("Eines der Argumente ist null");
        this.operator = operator;
        this.event = event;
    }

    public Operator getOperator() {
        return operator;
    }

    public CLIEvent getEvent() {
        return event;
    }
}

