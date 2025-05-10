package event.events;

public class GetAllergeneEvent extends OneAttributeEvent<Boolean> {

    public GetAllergeneEvent(boolean enthalten){
       super(enthalten);
    }
}
