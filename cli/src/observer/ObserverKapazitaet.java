package observer;

import observe.ObservableAutomat;
import observe.Observer;

public class ObserverKapazitaet implements Observer {
    private final ObservableAutomat automat;

    public ObserverKapazitaet(ObservableAutomat automat) {
        if (automat == null) throw new IllegalArgumentException("automat is null");
        this.automat = automat;
    }

    public void update() {
        int numberOfKuchen = this.automat.getNumberOfKuchen();
        int kapazitaet = this.automat.getKapazitaet();
        if ((kapazitaet / 100.0) * 90.0 <= numberOfKuchen)
            System.out.println("90% or more of automat kapazitaet reached");
    }
}
