package event.cli.events;

import event.cli.contract.CLIEvent;

public abstract class OneAttributeEvent<T> implements CLIEvent {
    private final T attribute;

    OneAttributeEvent(T attribute) {
        if (attribute == null) throw new NullPointerException("attribute ist null");
        this.attribute = attribute;
    }

    public T getAttribute(){
        return attribute;
    }
}
