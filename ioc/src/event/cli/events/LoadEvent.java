package event.cli.events;

public class LoadEvent extends AbstractCLIEvent<Boolean> {

    // true -> JOS, false -> JBP
    public LoadEvent(Boolean b){
        super(b);
    }
}

