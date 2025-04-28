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
    public ObsttorteImpl(BigDecimal preis, Hersteller hersteller,
                         Collection<Allergen> allergene, int naehrwert, Duration haltbarkeit,
                         String kremsorte, String obstsorte) {
        super(preis, hersteller,
                allergene, naehrwert, haltbarkeit
        );
        if (kremsorte == null || obstsorte == null) throw new NullPointerException("krem- oder obstsorte sind null");
        if (kremsorte.isEmpty() || obstsorte.isEmpty()) throw new IllegalArgumentException("krem- oder obstsorte sind empty");
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
