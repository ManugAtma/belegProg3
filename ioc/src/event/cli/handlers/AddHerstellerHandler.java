package event.cli.handlers;

import event.cli.contract.CLIEvent;
import event.cli.contract.CLIListener;

public class AddHerstellerHandler extends AbstractCLIHandler {

    public AddHerstellerHandler(CLIListener listener) {
        super(listener);
    }

    @Override
    public void handle(CLIEvent e){
        System.out.println("handling AddHerstellerEvent");
    }
}
