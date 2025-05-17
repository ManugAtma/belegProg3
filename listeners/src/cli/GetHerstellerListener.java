package cli;

import automat.Automat;
import event.cli.events.GetHerstellerEvent;
import event.model.events.OutputHerstellerEvent;
import event.model.handlers.OutputHerstellerHandler;
import verwaltung.Hersteller;

import java.util.Collection;
import java.util.Map;

public class GetHerstellerListener extends AbstractCLIListener<GetHerstellerEvent>{
    private final OutputHerstellerHandler handler;

    public GetHerstellerListener(Automat model, OutputHerstellerHandler handler) {
        super(model);
        if (handler == null) throw new NullPointerException("handler is null");
        this.handler = handler;
    }

    @Override
    public void onCLIEvent(GetHerstellerEvent event) {
        super.onCLIEvent(event);
        Collection<Map.Entry<Hersteller, Integer>> hersteller = this.model.getAlleHersteller();
        OutputHerstellerEvent outputEvent = new OutputHerstellerEvent(hersteller);
        this.handler.handleModelEvent(outputEvent);
    }
}
