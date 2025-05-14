package cli;

import automat.Automat;
import event.cli.events.AddKuchenEvent;

public class AddKuchenListener extends AbstractCLIListener<AddKuchenEvent> {

    public AddKuchenListener(Automat model){
        super(model);
    }

    @Override
    public void onCLIEvent(AddKuchenEvent event) {
        boolean b = this.model.addKuchen(event.getType(), event.getPreis(), event.getHersteller(),
                event.getAllergene(), event.getNaehrwert(), event.getHaltbarkeit(),
                event.getSorte1(), event.getSorte2()
        );
    }
}
