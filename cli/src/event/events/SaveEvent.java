package event.events;

public class SaveEvent extends OneAttributeEvent<Boolean> {

    // true -> JOS, false -> JBP
    public SaveEvent(Boolean b){
        super(b);
    }
}
