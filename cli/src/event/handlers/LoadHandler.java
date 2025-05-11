package event.handlers;

import event.contract.CLIEvent;
import event.contract.CLIHandler;

public class LoadHandler implements CLIHandler {

    @Override
    public void handle(CLIEvent e) {
        System.out.println("handling LoadEvent: " + e);
    }
}