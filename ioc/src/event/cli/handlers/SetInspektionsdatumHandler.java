package event.cli.handlers;

import event.cli.contract.CLIListener;
import event.cli.events.SetInspektionsdatumEvent;

public class SetInspektionsdatumHandler extends AbstractCLIHandler<SetInspektionsdatumEvent> {

    public SetInspektionsdatumHandler(CLIListener<SetInspektionsdatumEvent> listener) {
        super(listener);
    }
}