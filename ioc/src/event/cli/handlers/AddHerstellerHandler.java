package event.cli.handlers;

import event.cli.contract.CLIListener;
import event.cli.events.AddHerstellerEvent;

public class AddHerstellerHandler extends AbstractCLIHandler<AddHerstellerEvent> {

    public AddHerstellerHandler(CLIListener<AddHerstellerEvent> listener) {
        super(listener);
    }
}
