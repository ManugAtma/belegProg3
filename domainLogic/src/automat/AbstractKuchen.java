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

    BigDecimal preis;
    Date inspektionsdatum;
    int fachnummer;

    Date einfuegedatum;

    Hersteller hersteller;
    Collection<Allergen> allergene;
    int naehrwert;
    Duration haltbarkeit;


    public AbstractKuchen() {
    }

    // setter verwenden
    public AbstractKuchen(BigDecimal preis, int fachnummer,
                          Hersteller hersteller, Collection<Allergen> allergene,
                          int naehrwert, Duration haltbarkeit) {
        this.preis = preis;
        this.fachnummer = -1;  // noch kein Fach zugewiesen
        this.hersteller = hersteller;
        this.allergene = allergene;
        this.naehrwert = naehrwert;
        this.haltbarkeit = haltbarkeit;
    }

    public void setPreis(BigDecimal preis) {
        this.preis = preis;
    }

    @Override
    public BigDecimal getPreis() {
        return preis;
    }

    public void setInspektionsdatum(Date inspektionsdatum) {
        this.inspektionsdatum = inspektionsdatum;
    }

    @Override
    public Date getInspektionsdatum() {
        return inspektionsdatum;
    }

    public void setFachnummer(int fachnummer) {
        this.fachnummer = fachnummer;
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

    // keine setter einfuegedatum und haltbarkeit,da unveränderbar?
}
