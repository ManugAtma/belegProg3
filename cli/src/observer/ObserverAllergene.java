package observer;

import kuchen.Allergen;
import observe.ObservableAutomat;
import observe.Observer;

import java.util.List;

public class ObserverAllergene implements Observer {
    private final ObservableAutomat automat;
    private List<Allergen> oldAllergene;

    public ObserverAllergene(ObservableAutomat automat) {
        if (automat == null) throw new IllegalArgumentException("automat is null");
        this.automat = automat;
        this.oldAllergene = automat.getVorhandeneAllergeneList();
    }

    public void update() {
        List<Allergen> newAllergene = this.automat.getVorhandeneAllergeneList();

        if (this.oldAllergene.size() != newAllergene.size() /*|| !this.oldAllergene.containsAll(newAllergene)*/) {
            System.out.println("vorhandene allergene have changed. currently vorhandene allergene:");
            for (Allergen a : newAllergene) {
                System.out.println(" - " + a);
            }
            if (newAllergene.isEmpty()) System.out.println("(none)");
            this.oldAllergene = newAllergene;
        }
    }
}
