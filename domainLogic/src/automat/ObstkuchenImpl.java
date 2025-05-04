package automat;

import kuchen.Allergen;
import kuchen.Obstkuchen;
import verwaltung.Hersteller;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;


public class ObstkuchenImpl extends AbstractKuchen implements Obstkuchen {

    private String obstsorte;

    public ObstkuchenImpl(BigDecimal preis, Hersteller hersteller,
                          Collection<Allergen> allergene, int naehrwert,
                          Duration haltbarkeit, String obstsorte) {
        super(preis, hersteller,
                allergene, naehrwert, haltbarkeit
        );
        if (obstsorte == null) throw new NullPointerException("obstsorte ist null");
        if (obstsorte.isEmpty()) throw new IllegalArgumentException("obstsorte ist empty");
        this.obstsorte = obstsorte;
    }

    @Override
    public String getObstsorte() {
        return obstsorte;
    }
}

