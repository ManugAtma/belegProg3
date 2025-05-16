package event.cli.events;

import verwaltung.Hersteller;

public class AddHerstellerEvent extends AbstractCLIEvent<Hersteller> {

    public AddHerstellerEvent(Hersteller hersteller){
        super(hersteller);
    }
}
