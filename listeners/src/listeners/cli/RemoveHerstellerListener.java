package listeners.cli;

import automat.Automat;
import event.cli.events.RemoveHerstellerEvent;

public class RemoveHerstellerListener extends AbstractCLIListener<RemoveHerstellerEvent>{

    public RemoveHerstellerListener(Automat model) {
        super(model);
    }

    @Override
    public void onCLIEvent(RemoveHerstellerEvent event) {
        super.onCLIEvent(event);
        this.model.removeHersteller(event.getData());
    }
}
