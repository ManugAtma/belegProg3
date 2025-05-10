package event.events;

public class RemoveHerstellerEvent extends OneAttributeEvent<String> {

    public RemoveHerstellerEvent(String name){
        super(name);
    }
}
