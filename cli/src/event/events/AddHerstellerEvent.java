package event.events;

import verwaltung.Hersteller;

public class AddHerstellerEvent extends OneAttributeEvent<Hersteller> {

    public AddHerstellerEvent(Hersteller hersteller){
        super(hersteller);
    }
}
