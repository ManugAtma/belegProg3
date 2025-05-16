package event.model.handlers;

import event.model.contract.ModelEvent;
import event.model.contract.ModelHandler;
import event.model.contract.ModelListener;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class AbstractModelHandler <T extends ModelEvent> implements ModelHandler<T> {
    protected final List<ModelListener<T>> listeners = new CopyOnWriteArrayList<>();

    public AbstractModelHandler(ModelListener<T> listener) {
        if (listener == null) throw new NullPointerException("listener is null");
        listeners.add(listener);
    }

    public boolean addListener(ModelListener<T> listener) {
        if (listener == null) throw new NullPointerException("listener is null");
        return listeners.add(listener);
    }

    public boolean removeListener(ModelListener<T> listener) {
        if (listener == null) throw new NullPointerException("listener is null");
        return listeners.remove(listener);
    }

    @Override
    public void handleModelEvent(T event) {
        for (ModelListener<T> listener : listeners) {
            listener.onModelEvent(event);
        }
    }


}
