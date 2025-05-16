package event.model.events;

import kuchen.Allergen;

import java.util.Collection;
import java.util.Collections;

public class OutputAllergeneEvent extends AbstractModelEvent<Collection<Allergen>> {
    private final boolean enthaltene;

    public OutputAllergeneEvent(Collection<Allergen> allergene, boolean enthaltene) {
        super(allergene);
        this.enthaltene = enthaltene;
    }

    @Override
    public Collection<Allergen> getData() {
        return Collections.unmodifiableCollection(data);
    }

    public boolean isEnthalten() {
        return enthaltene;
    }
}
