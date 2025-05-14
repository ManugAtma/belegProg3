package event.cli.handlers;

import event.cli.contract.CLIEvent;
import event.cli.contract.CLIHandler;

public class SaveHandler implements CLIHandler {

    @Override
    public void handle(CLIEvent e) {
        System.out.println("handling SaveEvent: " + e);

    }
}