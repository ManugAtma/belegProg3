package event.model.handlers;

import event.model.contract.ModelListener;
import event.model.events.OutputAllergeneEvent;

public class OutputAllergeneHandler extends AbstractModelHandler<OutputAllergeneEvent> {

    public OutputAllergeneHandler(ModelListener<OutputAllergeneEvent> listener){
        super(listener);
    }

   /* @Override
    public void handleModelEvent(OutputAllergeneEvent event){
        for (ModelListener<OutputAllergeneEvent> listener: this.listeners){
            listener.onModelEvent(event);
        }
    }*/
}
