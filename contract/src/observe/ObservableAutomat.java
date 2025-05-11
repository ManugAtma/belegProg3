package observe;


import kuchen.Allergen;

import java.util.List;

public interface ObservableAutomat {

    int getKapazitaet();

    int getNumberOfKuchen();

    List<Allergen> getVorhandeneAllergeneList();

    List<Allergen> getNichtVorhandeneAllergeneList();
}
