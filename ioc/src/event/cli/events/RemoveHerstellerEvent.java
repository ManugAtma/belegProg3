package event.cli.events;

public class RemoveHerstellerEvent extends AbstractCLIEvent<String> {

    public RemoveHerstellerEvent(String name){
        super(name);
    }
}
