package event.model.events;

import event.dto.KuchenDTO;

import java.util.Collection;

public class OutputKuchenEvent extends AbstractModelEvent<Collection<KuchenDTO>> {

    public OutputKuchenEvent(Collection<KuchenDTO> data) {
        super(data);
    }


}
