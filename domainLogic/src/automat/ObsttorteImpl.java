package automat;

import kuchen.Allergen;
import kuchen.Obsttorte;
import verwaltung.Hersteller;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;

public class ObsttorteImpl extends AbstractKuchen implements Obsttorte {
    private String obstsorte;
    private String kremsorte;


    // hier inspektionsdatum = einfuegedatum setzen?
    public ObsttorteImpl(BigDecimal preis, int fachnummer, Hersteller hersteller,
                         Collection<Allergen> allergene, int naehrwert, Duration haltbarkeit,
                         String kremsorte, String obstsorte) {
        super(preis, fachnummer, hersteller,
                allergene, naehrwert, haltbarkeit
        );
        this.kremsorte = kremsorte;
        this.obstsorte = obstsorte;
    }

    @Override
    public String getObstsorte() {
        return obstsorte;
    }

    @Override
    public String getKremsorte() {
        return kremsorte;
    }
}
