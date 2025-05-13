package automat;

import kuchen.Allergen;
import kuchen.Obsttorte;
import verwaltung.Hersteller;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;


public class ObsttorteImpl extends ObstkuchenImpl implements Obsttorte {
    private  String obstsorte;
    private String kremsorte;


    // hier inspektionsdatum = einfuegedatum setzen?
    public ObsttorteImpl(BigDecimal preis, Hersteller hersteller,
                         Collection<Allergen> allergene, int naehrwert, Duration haltbarkeit,
                         String kremsorte, String obstsorte) {
        super(preis, hersteller,
                allergene, naehrwert,
                haltbarkeit, obstsorte
        );
        if (kremsorte == null) throw new NullPointerException("kremsorte is null");
        if (kremsorte.isEmpty()) throw new IllegalArgumentException("kremsorte is empty");
        this.kremsorte = kremsorte;
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
