package cli;

import automat.Automat;
import event.cli.events.SetInspektionsdatumEvent;

import java.util.Date;

public class SetInspektionsdatumListener extends AbstractCLIListener<SetInspektionsdatumEvent> {

    public SetInspektionsdatumListener(Automat model) {
        super(model);
    }

    @Override
    public void onCLIEvent(SetInspektionsdatumEvent event) {
        super.onCLIEvent(event);
        this.model.setInspektionsdatum(event.getData() - 1, new Date());
    }
}
