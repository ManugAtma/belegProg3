package event.model.events;

import event.dto.KuchenDTO;
import kuchen.Kuchen;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

public class OutputKuchenEvent extends AbstractModelEvent<Collection<KuchenDTO>> {

    public OutputKuchenEvent(Collection<KuchenDTO> data) {
        super(data);
    }


}
