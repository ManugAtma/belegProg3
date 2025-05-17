package listeners.model;

import event.model.events.OutputHerstellerEvent;
import verwaltung.Hersteller;

import java.util.Map;

public class OutputHerstellerListener extends AbstractModelListener<OutputHerstellerEvent> {



    @Override
    public void onModelEvent(OutputHerstellerEvent event) {
        super.onModelEvent(event);
        System.out.println("current hersteller with number of kuchen:");
        for (Map.Entry<Hersteller, Integer> entry : event.getData()) {
            System.out.println("  - " + entry.getKey().getName() + ": " + entry.getValue() + " kuchen");
        }
    }
}
