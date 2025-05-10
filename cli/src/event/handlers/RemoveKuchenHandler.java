package event.handlers;

import event.contract.CLIEvent;
import event.contract.CLIHandler;

public class RemoveKuchenHandler implements CLIHandler {

    @Override
    public void handle(CLIEvent e) {
        System.out.println("handling RemoveKuchenEvent: " + e);

    }
}