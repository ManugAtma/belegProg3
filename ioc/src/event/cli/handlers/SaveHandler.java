package event.cli.handlers;

import event.cli.contract.CLIListener;
import event.cli.events.SaveEvent;

public class SaveHandler extends AbstractCLIHandler<SaveEvent> {

    public SaveHandler(CLIListener<SaveEvent> listener) {
        super(listener);
    }

    @Override
    public void handle(SaveEvent e) {
        System.out.println("handling SaveEvent: " + e);
    }
}