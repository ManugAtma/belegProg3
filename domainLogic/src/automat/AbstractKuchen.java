package automat;

import kuchen.Allergen;
import kuchen.Kuchen;
import verwaltung.Hersteller;
import verwaltung.Verkaufsobjekt;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;
import java.util.Date;


public abstract class AbstractKuchen implements Kuchen, Verkaufsobjekt {

    private BigDecimal preis;
    private Date inspektionsdatum;
    private int fachnummer;

    private Date einfuegedatum;

    private Hersteller hersteller;
    private Collection<Allergen> allergene;
    private int naehrwert;
    private Duration haltbarkeit;

    // setter verwenden?
    // was, wenn Kuchen keine Allergene hat? allergene dann null oder leere collection
    public AbstractKuchen(BigDecimal preis, Hersteller hersteller, Collection<Allergen> allergene,
                          int naehrwert, Duration haltbarkeit) {

        if (preis == null || hersteller == null || allergene == null || haltbarkeit == null)
            throw new NullPointerException("kein argument darf null sein.");
        if ((preis.compareTo(new BigDecimal(0)) < 0) || (naehrwert < 0) || (haltbarkeit.isNegative()))
            throw new IllegalArgumentException("preis, naehrwert und haltbarkeit koennen nicht negativ sein");

        this.preis = preis;
        this.fachnummer = -1;  // Fehlerwert, da noch kein Fach zugewiesen
        this.hersteller = hersteller;
        this.allergene = allergene;
        this.naehrwert = naehrwert;
        this.haltbarkeit = haltbarkeit;
    }

    @Override
    public BigDecimal getPreis() {
        return preis;
    }

    @Override
    public Date getInspektionsdatum() {
        return inspektionsdatum;
    }

    @Override
    public int getFachnummer() {
        return fachnummer;
    }

    @Override
    public Hersteller getHersteller() {
        return hersteller;
    }

    @Override
    public Collection<Allergen> getAllergene() {
        return allergene;
    }

    @Override
    public int getNaehrwert() {
        return naehrwert;
    }

    @Override
    public Duration getHaltbarkeit() {
        return haltbarkeit;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " (" +
                "fachnummer: " + fachnummer +
                ", einfuegedatum: " + einfuegedatum +
                ", preis: " + preis +
                ", inspektionsdatum: " + inspektionsdatum +
                ", hersteller: " + (hersteller != null ? hersteller.getName() : "null") +
                ", allergene: " + (allergene != null && !allergene.isEmpty() ? allergene.toString() : "keine") +
                ", naehrwert: " + naehrwert +
                ", haltbarkeit: " + haltbarkeit +
                ')';
    }

    public Date getEinfuegedatum(){
        return einfuegedatum;
    }

    void setFachnummer(int fachnummer) {
        if (fachnummer < 0) throw new IllegalArgumentException("fachnummer kann nicht negativ sein");
        this.fachnummer = fachnummer;
    }

    void setInspektionsdatum(Date inspektionsdatum) {
        if (inspektionsdatum == null) throw new NullPointerException("inspektionsdatum kann nicht null sein");
        this.inspektionsdatum = inspektionsdatum;
    }

    void setEinfuegedatum(Date datum) {
        if (datum == null) throw new NullPointerException("einfuegedatum kann nicht null sein");
        einfuegedatum = datum;
    }

    /*void setPreis(BigDecimal preis) {
        this.preis = preis;
    }*/

}
