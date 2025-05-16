package cli;

import automat.AbstractKuchen;
import automat.Automat;
import event.cli.events.GetKuchenEvent;
import event.model.events.OutputKuchenEvent;
import event.model.handlers.OutputKuchenHandler;
import kuchen.Kuchen;

import java.util.ArrayList;
import java.util.Collection;

public class GetKuchenListener extends AbstractCLIListener<GetKuchenEvent> {

    public GetKuchenListener(Automat model, OutputKuchenHandler handler) {
        super(model);
    }

    @Override
    public void onCLIEvent(GetKuchenEvent event) {

        String kuchenType = event.getKuchenType();
        boolean filterByType = kuchenType != null;

        Collection<Kuchen> kuchen = this.model.getAlleKuchen(kuchenType, filterByType);


        OutputKuchenEvent outputEvent = new OutputKuchenEvent(kuchen);
    }
}
