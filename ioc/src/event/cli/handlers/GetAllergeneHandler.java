package event.cli.handlers;

import event.cli.contract.CLIListener;
import event.cli.events.GetAllergeneEvent;

public class GetAllergeneHandler extends AbstractCLIHandler<GetAllergeneEvent> {

    public GetAllergeneHandler(CLIListener<GetAllergeneEvent> listener) {
        super(listener);
    }
}