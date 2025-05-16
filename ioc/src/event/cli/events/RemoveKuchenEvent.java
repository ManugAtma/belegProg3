package event.cli.events;

public class RemoveKuchenEvent extends AbstractCLIEvent<Integer> {

    public RemoveKuchenEvent(Integer fachnummer) {
        super(fachnummer);
    }
}