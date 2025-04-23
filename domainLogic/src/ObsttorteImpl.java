import kuchen.Allergen;
import kuchen.Obsttorte;
import verwaltung.Hersteller;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;
import java.util.Date;

public class ObsttorteImpl extends AbstractKuchen implements Obsttorte {
    private String obstsorte;
    private String kremsorte;

    public ObsttorteImpl(){}

    // hier inspektionsdatum = einfuegedatum setzen?
    public ObsttorteImpl(BigDecimal preis, Date inspektionsdatum,
                         int fachnummer, Hersteller hersteller,
                         Collection<Allergen> allergene,
                         int naehrwert, Duration haltbarkeit,
                         String kremsorte, String obstsorte) {
        super(preis, inspektionsdatum, fachnummer,
                hersteller, allergene,
                naehrwert, haltbarkeit
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
