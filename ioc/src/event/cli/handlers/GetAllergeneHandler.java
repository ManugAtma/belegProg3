package event.cli.handlers;

import event.cli.contract.CLIEvent;
import event.cli.contract.CLIHandler;
import event.cli.contract.CLIListener;
import event.cli.events.GetAllergeneEvent;

public class GetAllergeneHandler extends AbstractCLIHandler<GetAllergeneEvent> {

    public GetAllergeneHandler(CLIListener<GetAllergeneEvent> listener) {
        super(listener);
    }
}