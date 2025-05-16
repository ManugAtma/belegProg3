package event.model.events;

import kuchen.Kuchen;

import java.util.Collection;

public class OutputKuchenEvent extends AbstractModelEvent<Collection<Kuchen>> {

    public OutputKuchenEvent(Collection<Kuchen> data) {
        super(data);
    }
}
