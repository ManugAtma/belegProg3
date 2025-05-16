package event.cli.events;

public class SaveEvent extends AbstractCLIEvent<Boolean> {

    // true -> JOS, false -> JBP
    public SaveEvent(Boolean b){
        super(b);
    }
}
