package model;

import event.model.events.OutputAllergeneEvent;

public class OutputAllergeneListener extends AbstractModelListener<OutputAllergeneEvent> {

    @Override
    public void onModelEvent(OutputAllergeneEvent event) {


        if (event.isEnthalten()) {
            System.out.println("the automat currently contains these allergens: " + event.getData());
            return;
        }

        System.out.println("the automat currently does not contain these allergens: " + event.getData());

    }
}
