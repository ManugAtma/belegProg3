package event.model.contract;

public interface ModelListener <T extends ModelEvent>{

    void onModelEvent(T event);
}
