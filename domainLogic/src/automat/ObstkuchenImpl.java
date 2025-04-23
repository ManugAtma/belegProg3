package automat;

import kuchen.Allergen;
import kuchen.Obstkuchen;
import verwaltung.Hersteller;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;

public class ObstkuchenImpl extends AbstractKuchen implements Obstkuchen {

    private String obstsorte;

    public ObstkuchenImpl(){}

    public ObstkuchenImpl(BigDecimal preis, int fachnummer, Hersteller hersteller,
                          Collection<Allergen> allergene, int naehrwert,
                          Duration haltbarkeit, String obstsorte) {
        super(preis, fachnummer, hersteller,
                allergene, naehrwert, haltbarkeit
        );
        this.obstsorte = obstsorte;
    }

    @Override
    public String getObstsorte() {
        return obstsorte;
    }
}

