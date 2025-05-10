package event.events;

public class RemoveKuchenEvent extends OneAttributeEvent<Integer> {

    public RemoveKuchenEvent(Integer fachnummer) {
        super(fachnummer);
    }
}