package event.cli.handlers;

import event.cli.contract.CLIEvent;
import event.cli.contract.CLIHandler;

public class RemoveKuchenHandler implements CLIHandler {

    @Override
    public void handle(CLIEvent e) {
        System.out.println("handling RemoveKuchenEvent: " + e);

    }
}