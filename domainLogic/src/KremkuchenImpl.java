import kuchen.Allergen;
import kuchen.Kremkuchen;
import verwaltung.Hersteller;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;
import java.util.Date;

public class KremkuchenImpl extends AbstractKuchen implements Kremkuchen {
    private String kremsorte;

    public KremkuchenImpl() {}

    // hier inspektionsdatum = einfuegedatum setzen?
    public KremkuchenImpl(BigDecimal preis, Date inspektionsdatum,
                          int fachnummer, Hersteller hersteller,
                          Collection<Allergen> allergene, int naehrwert,
                          Duration haltbarkeit, String kremsorte) {
        super(preis, inspektionsdatum, fachnummer,
                hersteller, allergene,
                naehrwert, haltbarkeit
        );
        this.kremsorte = kremsorte;
    }

    @Override
    public String getKremsorte() {
        return kremsorte;
    }
}
