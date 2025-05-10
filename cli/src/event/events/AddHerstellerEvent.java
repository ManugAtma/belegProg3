package event.events;

import verwaltung.Hersteller;

public class AddHerstellerEvent extends OneArgEvent<Hersteller>{

    public AddHerstellerEvent(Hersteller hersteller){
        super(hersteller);
    }
}
