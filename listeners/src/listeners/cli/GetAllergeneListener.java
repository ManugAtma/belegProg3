package listeners.cli;

import automat.Automat;
import event.cli.events.GetAllergeneEvent;
import event.model.events.OutputAllergeneEvent;
import event.model.handlers.OutputAllergeneHandler;
import kuchen.Allergen;

import java.util.Collection;

public class GetAllergeneListener extends AbstractCLIListener<GetAllergeneEvent> {
    private final OutputAllergeneHandler handler;

    public GetAllergeneListener(Automat model, OutputAllergeneHandler handler) {
        super(model);
        if (handler == null) throw new NullPointerException("handler is null");
        this.handler = handler;
    }

    @Override
    public void onCLIEvent(GetAllergeneEvent event) {

        Collection<Allergen> allergene = null;
        if (event.getData()) allergene = this.model.getVorhandeneAllergeneList();
        else allergene = this.model.getNichtVorhandeneAllergeneList();

        boolean enthaltene = event.getData();
        OutputAllergeneEvent outputEvent = new OutputAllergeneEvent(allergene, enthaltene);
        this.handler.handleModelEvent(outputEvent);
    }
}
