package event.model.handlers;

import event.model.contract.ModelListener;
import event.model.events.OutputKuchenEvent;

public class OutputKuchenHandler extends AbstractModelHandler<OutputKuchenEvent>{

    public OutputKuchenHandler(ModelListener<OutputKuchenEvent> listener){
        super(listener);
    }
}
