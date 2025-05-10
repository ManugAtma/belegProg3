package event.events;

import automat.AbstractKuchen;
import event.contract.CLIEvent;

public class AddKuchenEvent implements CLIEvent {
    AbstractKuchen kuchen;

    public AddKuchenEvent(AbstractKuchen kuchen){
        if (kuchen == null) throw new NullPointerException("kuchen is null");
        this.kuchen = kuchen;
    }

    public AbstractKuchen getKuchen() {
        return kuchen;
    }
}
