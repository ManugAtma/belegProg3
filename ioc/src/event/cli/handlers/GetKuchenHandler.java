package event.cli.handlers;

import event.cli.contract.CLIListener;
import event.cli.events.GetKuchenEvent;

public class GetKuchenHandler extends AbstractCLIHandler<GetKuchenEvent> {

   public GetKuchenHandler(CLIListener<GetKuchenEvent> listener) {
       super(listener);
   }
}
