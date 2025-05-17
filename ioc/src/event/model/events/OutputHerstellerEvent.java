package event.model.events;

import verwaltung.Hersteller;

import java.util.Collection;
import java.util.Map;

public class OutputHerstellerEvent extends AbstractModelEvent<Collection<Map.Entry<Hersteller, Integer>>> {

    public OutputHerstellerEvent(Collection<Map.Entry<Hersteller, Integer>> data) {
        super(data);
    }
}
