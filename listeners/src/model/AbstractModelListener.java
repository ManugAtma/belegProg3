package model;

import event.model.contract.ModelEvent;
import event.model.contract.ModelListener;

public abstract class AbstractModelListener<T extends ModelEvent> implements ModelListener<T> {
}
