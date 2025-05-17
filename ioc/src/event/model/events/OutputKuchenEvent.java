package event.model.events;

import event.dto.KuchenDTO;

import java.util.Collection;

public class OutputKuchenEvent extends AbstractModelEvent<Collection<KuchenDTO>> {
    String filteredByType;

    public OutputKuchenEvent(Collection<KuchenDTO> data, String filteredByType) {
        super(data);
        this.filteredByType = filteredByType;
    }

    public String getFilteredByType() {
        return filteredByType;
    }


}
