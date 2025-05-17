package event.cli.handlers;

import event.cli.contract.CLIListener;
import event.cli.events.LoadEvent;

public class LoadHandler extends AbstractCLIHandler<LoadEvent> {

    public LoadHandler(CLIListener<LoadEvent> listener) {
        super(listener);
    }

    @Override
    public void handle(LoadEvent e) {
        System.out.println("handling LoadEvent: " + e);
    }
}