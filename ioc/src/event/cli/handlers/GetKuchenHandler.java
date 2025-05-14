package event.cli.handlers;

import event.cli.contract.CLIEvent;
import event.cli.contract.CLIHandler;

public class GetKuchenHandler implements CLIHandler {

    @Override
    public void handle(CLIEvent e) {
        System.out.println("handling GetKuchenEvent: " + e);
    }
}
