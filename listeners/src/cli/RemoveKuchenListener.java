package cli;

import automat.Automat;
import event.cli.events.RemoveKuchenEvent;

public class RemoveKuchenListener extends AbstractCLIListener<RemoveKuchenEvent>{

    public RemoveKuchenListener(Automat model) {
        super(model);
    }

    @Override
    public void onCLIEvent(RemoveKuchenEvent event) {
        this.model.removeKuchen(event.getData());
    }
}
