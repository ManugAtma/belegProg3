package event.cli.handlers;

import event.cli.contract.CLIListener;
import event.cli.events.RemoveHerstellerEvent;

public class RemoveHerstellerHandler extends AbstractCLIHandler<RemoveHerstellerEvent> {

    public RemoveHerstellerHandler(CLIListener<RemoveHerstellerEvent> listener) {
        super(listener);
    }
}