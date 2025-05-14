package event.cli.handlers;

import event.cli.contract.CLIEvent;
import event.cli.contract.CLIHandler;

public class LoadHandler implements CLIHandler {

    @Override
    public void handle(CLIEvent e) {
        System.out.println("handling LoadEvent: " + e);
    }
}