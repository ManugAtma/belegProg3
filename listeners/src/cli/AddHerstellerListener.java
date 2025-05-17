package cli;

import automat.Automat;
import event.cli.events.AddHerstellerEvent;

public class AddHerstellerListener extends AbstractCLIListener<AddHerstellerEvent>{

    public AddHerstellerListener(Automat model) {
        super(model);
    }

    @Override
    public void onCLIEvent(AddHerstellerEvent event) {
        super.onCLIEvent(event);
        this.model.addHersteller(event.getData());
    }
}
