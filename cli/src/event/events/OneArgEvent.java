package event.events;

import event.contract.CLIEvent;

public abstract class OneArgEvent<T> implements CLIEvent {
    T argument;

    OneArgEvent(T argument) {
        if (argument == null) throw new NullPointerException("argument ist null");
        this.argument = argument;
    }
}
