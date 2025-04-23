package automat;

import kuchen.Allergen;
import kuchen.Kremkuchen;
import verwaltung.Hersteller;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;

public class KremkuchenImpl extends AbstractKuchen implements Kremkuchen {
    private String kremsorte;

    // hier inspektionsdatum = einfuegedatum setzen?
    public KremkuchenImpl(BigDecimal preis, int fachnummer, Hersteller hersteller,
                          Collection<Allergen> allergene, int naehrwert,
                          Duration haltbarkeit, String kremsorte) {
        super(preis, fachnummer, hersteller,
                allergene, naehrwert, haltbarkeit
        );
        this.kremsorte = kremsorte;
    }

    @Override
    public String getKremsorte() {
        return kremsorte;
    }
}
