package event.cli.events;

import event.cli.contract.CLIEvent;

public abstract class AbstractCLIEvent<T> implements CLIEvent {
    private final T data;

    AbstractCLIEvent(T data) {
        if (data == null) throw new NullPointerException("data ist null");
        this.data = data;
    }

    public T getData(){
        return data;
    }


}
