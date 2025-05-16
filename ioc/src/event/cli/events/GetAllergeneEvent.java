package event.cli.events;

public class GetAllergeneEvent extends AbstractCLIEvent<Boolean> {

    public GetAllergeneEvent(boolean enthalten){
       super(enthalten);
    }
}
