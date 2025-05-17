package model;

import event.dto.KuchenDTO;
import event.model.events.OutputKuchenEvent;
import kuchen.Kuchen;

import java.time.Duration;
import java.util.Collection;
import java.util.Date;

public class OutputKuchenListener extends AbstractModelListener<OutputKuchenEvent> {
    Date begin = new Date();

    @Override
    public void onModelEvent(OutputKuchenEvent event) {
        super.onModelEvent(event);

        Date now = new Date();
        long difference = now.getTime() - begin.getTime();
        Duration duration = Duration.ofMillis(difference);
        Collection<KuchenDTO> dtos = event.getData();

        for (KuchenDTO dto : dtos) {
            Kuchen kuchen = dto.getKuchen();
            Duration haltbarkeit = kuchen.getHaltbarkeit();
            long remainingTime = haltbarkeit.minus(duration).getSeconds();
            String inspektionsdatum = (dto.getInspektionsdatum() == null) ? "not set" : dto.getInspektionsdatum().toString();
            String type = kuchen.getClass().getSimpleName();
            type = type.substring(0, type.length() - 4);

            System.out.println("type: " + type
                    + ", hersteller: " + kuchen.getHersteller().getName()
                    + ", fachnummmer: " + dto.getFachnummer()
                    + ", inspektionsdatum: " + inspektionsdatum
                    + ", verbleibende haltbarkeit in seconds: " + remainingTime);
        }
    }
}
