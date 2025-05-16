package event.model.events;

import event.model.contract.ModelEvent;

public abstract class AbstractModelEvent<T> implements ModelEvent {
    protected final T data;

    public AbstractModelEvent(T data) {
        if (data == null) throw new NullPointerException("data is null");
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
