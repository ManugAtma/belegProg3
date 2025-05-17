package cli;

import automat.AbstractKuchen;
import automat.Automat;
import event.cli.events.GetKuchenEvent;
import event.dto.KuchenDTO;
import event.model.contract.ModelHandler;
import event.model.events.OutputKuchenEvent;
import event.model.handlers.OutputKuchenHandler;

import java.util.ArrayList;
import java.util.Collection;

public class GetKuchenListener extends AbstractCLIListener<GetKuchenEvent> {
    ModelHandler<OutputKuchenEvent> handler;

    public GetKuchenListener(Automat model, OutputKuchenHandler handler) {
        super(model);
        if (handler == null) throw new NullPointerException("handler is null");
        this.handler = handler;
    }

    @Override
    public void onCLIEvent(GetKuchenEvent event) {

        String kuchenType = event.getKuchenType();
        boolean filterByType = kuchenType != null;
        Collection<AbstractKuchen> kuchen = this.model.getAlleKuchen(kuchenType, filterByType);

        Collection<KuchenDTO> dtoList = new ArrayList<>();
        for (AbstractKuchen k : kuchen) {
            KuchenDTO dto = new KuchenDTO(k, k.getInspektionsdatum(), k.getFachnummer());
            dtoList.add(dto);
        }

        OutputKuchenEvent outputEvent = new OutputKuchenEvent(dtoList);
        this.handler.handleModelEvent(outputEvent);
    }
}
