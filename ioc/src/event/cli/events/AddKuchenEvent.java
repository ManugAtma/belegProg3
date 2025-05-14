package event.cli.events;

import event.cli.contract.CLIEvent;
import kuchen.Allergen;
import verwaltung.Hersteller;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;
import java.util.Collections;

public class AddKuchenEvent implements CLIEvent {
    private String type;
    private BigDecimal preis;
    private Hersteller hersteller;
    private Collection<Allergen> allergene;
    private int naehrwert;
    private Duration haltbarkeit;
    private String sorte1;
    private String sorte2;

    public AddKuchenEvent(String type, BigDecimal preis, Hersteller hersteller, Collection<Allergen> allergene,
                          int naehrwert, Duration haltbarkeit, String sorte1, String sorte2) {

        if (type == null || preis == null || hersteller == null
                || allergene == null || haltbarkeit == null
                || sorte1 == null) throw new NullPointerException("an arguments is null");
        this.type = type;
        this.preis = preis;
        this.hersteller = hersteller;
        this.allergene = allergene;
        this.naehrwert = naehrwert;
        this.haltbarkeit = haltbarkeit;
        this.sorte1 = sorte1;
        this.sorte2 = sorte2;
    }

    public String getType(){
        return type;
    }

    public BigDecimal getPreis() {
        return preis;
    }

    public Hersteller getHersteller() {
        return hersteller;
    }

    public Collection<Allergen> getAllergene() {
        return Collections.unmodifiableCollection(allergene);

    }

    public int getNaehrwert() {
        return naehrwert;
    }

    public Duration getHaltbarkeit() {
        return haltbarkeit;
    }

    public String getSorte1() {
        return sorte1;
    }

    public String getSorte2() {
        return sorte2;
    }
}
