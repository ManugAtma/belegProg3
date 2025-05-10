package event.events;

import automat.AbstractKuchen;

public class AddKuchenEvent extends OneAttributeEvent<AbstractKuchen> {
    AbstractKuchen kuchen;

    public AddKuchenEvent(AbstractKuchen kuchen){
       super(kuchen);
    }

}
