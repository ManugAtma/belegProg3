package event.model.contract;

public interface ModelHandler <T extends ModelEvent> {

    void handleModelEvent(T event);
}
