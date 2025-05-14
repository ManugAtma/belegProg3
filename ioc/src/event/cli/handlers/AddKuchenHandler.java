package event.cli.handlers;

import event.cli.contract.CLIListener;
import event.cli.events.AddKuchenEvent;

public class AddKuchenHandler extends AbstractCLIHandler<AddKuchenEvent> {

    public AddKuchenHandler(CLIListener<AddKuchenEvent> listener) {
        super(listener);
    }
}