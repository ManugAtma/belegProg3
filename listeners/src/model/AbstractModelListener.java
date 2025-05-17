package model;

import event.model.contract.ModelEvent;
import event.model.contract.ModelListener;

public abstract class AbstractModelListener<T extends ModelEvent> implements ModelListener<T> {

    @Override
    public void onModelEvent(T event) {
        if (event == null) throw new NullPointerException("event is null");
    }
}
