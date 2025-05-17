package event.model.handlers;

import event.model.contract.ModelListener;
import event.model.events.OutputHerstellerEvent;

public class OutputHerstellerHandler extends AbstractModelHandler<OutputHerstellerEvent>{

    public OutputHerstellerHandler(ModelListener<OutputHerstellerEvent> listener) {
        super(listener);
    }
}
