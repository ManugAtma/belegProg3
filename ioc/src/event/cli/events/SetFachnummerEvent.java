package event.cli.events;

public class SetFachnummerEvent extends OneAttributeEvent<Integer>{

    public SetFachnummerEvent(Integer i){
        super(i);
    }
}
