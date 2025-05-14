package automat;

import kuchen.Allergen;
import kuchen.Kremkuchen;
import verwaltung.Hersteller;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;


class KremkuchenImpl extends AbstractKuchen implements Kremkuchen {
    private String kremsorte;

    // hier inspektionsdatum = einfuegedatum setzen?
    public KremkuchenImpl(BigDecimal preis, Hersteller hersteller,
                          Collection<Allergen> allergene, int naehrwert,
                          Duration haltbarkeit, String kremsorte) {
        super(preis, hersteller,
                allergene, naehrwert, haltbarkeit
        );
        if (kremsorte == null) throw new NullPointerException("kremsorte ist null");
        if (kremsorte.isEmpty()) throw new IllegalArgumentException("kremsorte ist empty");
        this.kremsorte = kremsorte;
    }

    @Override
    public String getKremsorte() {
        return kremsorte;
    }
}
