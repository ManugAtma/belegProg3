package event.handlers;

import event.contract.CLIEvent;
import event.contract.CLIHandler;

public class RemoveHerstellerHandler implements CLIHandler {

    @Override
    public void handle(CLIEvent e) {
        System.out.println("handling RemoveHerstellerEvent: " + e);
    }
}