package event.events;

public class LoadEvent extends OneAttributeEvent<Boolean> {

    // true -> JOS, false -> JBP
    public LoadEvent(Boolean b){
        super(b);
    }
}