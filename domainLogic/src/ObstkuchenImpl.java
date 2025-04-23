import kuchen.Allergen;
import kuchen.Kremkuchen;
import kuchen.Obstkuchen;
import verwaltung.Hersteller;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;
import java.util.Date;

public class ObstkuchenImpl extends AbstractKuchen implements Obstkuchen {

    private String obstsorte;

    public ObstkuchenImpl(){}

    public ObstkuchenImpl(BigDecimal preis, Date inspektionsdatum,
                          int fachnummer, Hersteller hersteller,
                          Collection<Allergen> allergene, int naehrwert,
                          Duration haltbarkeit, String obstsorte) {
        super(preis, inspektionsdatum, fachnummer,
                hersteller, allergene, naehrwert, haltbarkeit
        );
        this.obstsorte = obstsorte;
    }

    @Override
    public String getObstsorte() {
        return obstsorte;
    }
}

