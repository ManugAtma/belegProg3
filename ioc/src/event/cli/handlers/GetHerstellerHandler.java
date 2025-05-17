package event.cli.handlers;

import event.cli.contract.CLIListener;
import event.cli.events.GetHerstellerEvent;

public class GetHerstellerHandler extends AbstractCLIHandler<GetHerstellerEvent> {

    public GetHerstellerHandler(CLIListener<GetHerstellerEvent> listener) {
        super(listener);
    }
}