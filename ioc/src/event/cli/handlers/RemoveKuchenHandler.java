package event.cli.handlers;

import event.cli.contract.CLIListener;
import event.cli.events.RemoveKuchenEvent;

public class RemoveKuchenHandler extends AbstractCLIHandler<RemoveKuchenEvent> {

    public RemoveKuchenHandler(CLIListener<RemoveKuchenEvent> listener) {
        super(listener);
    }
}