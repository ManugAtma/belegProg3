package automat;

import kuchen.Allergen;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class TestAbstractKuchen {

    @Test
    public void shouldReturnTrueBecauseObjectWasCreatedSuccesfully() {
        KremkuchenImpl k = new KremkuchenImpl(
                new BigDecimal("4.50"), new HerstellerImpl("Monte"),
                List.of(Allergen.Erdnuss), 350, Duration.ofDays(4),
                "Vanille"
        );
        assertNotEquals(null, k);
    }

    @Test
    public void shouldThrowNPEBecauseHerstellerIsNull() {

        assertThrows(NullPointerException.class, () -> new KremkuchenImpl(
                new BigDecimal("4.50"), null,
                List.of(Allergen.Erdnuss), 350, Duration.ofDays(4),
                "Vanille")
        );
    }

    @Test
    public void shouldThrowNPEBecausePreisIsNull() {
        assertThrows(NullPointerException.class, () -> new KremkuchenImpl(
                null, new HerstellerImpl("Monte"),
                List.of(Allergen.Erdnuss), 350,
                Duration.ofDays(4), "Vanille")
        );
    }

    @Test
    public void shouldThrowNPEBecauseAllergeneIsNull() {
        assertThrows(NullPointerException.class, () -> new KremkuchenImpl(
                new BigDecimal("4.50"), new HerstellerImpl("Monte"),
                null, 350,
                Duration.ofDays(4), "Vanille")
        );
    }

    @Test
    public void shouldThrowNPEBecauseHaltbarkeitIsNull() {
        assertThrows(NullPointerException.class, () -> new KremkuchenImpl(
                new BigDecimal("4.50"), new HerstellerImpl("Monte"),
                List.of(Allergen.Erdnuss), 350,
                null, "Vanille")
        );
    }


    @Test
    public void shouldThrowIllegalArgumentBecauseNaehrwertIsNegative() {

        assertThrows(IllegalArgumentException.class, () -> new KremkuchenImpl(
                new BigDecimal("4.50"), new HerstellerImpl("Monte"),
                List.of(Allergen.Erdnuss), -5, Duration.ofDays(4),
                "Vanille")
        );
    }

    @Test
    public void shouldThrowIllegalArgumentBecausePriceIsNegative() {

        assertThrows(IllegalArgumentException.class, () -> new KremkuchenImpl(
                new BigDecimal(-4.50), new HerstellerImpl("Monte"),
                List.of(Allergen.Erdnuss), 5, Duration.ofDays(4),
                "Vanille")
        );
    }

    @Test
    public void shouldReturnCorrectPriceForGetPrice() {
        BigDecimal preis = new BigDecimal("4.50");
        KremkuchenImpl k = new KremkuchenImpl(
                preis, new HerstellerImpl("Monte"),
                List.of(Allergen.Erdnuss), 350, Duration.ofDays(4),
                "Vanille"
        );
        assertEquals(preis, k.getPreis());

    }

    @Test
    public void shouldReturnCorrectHerstellerForGetHersteller() {
        HerstellerImpl hersteller = new HerstellerImpl("Monte");
        KremkuchenImpl k = new KremkuchenImpl(
                new BigDecimal("4.50"), hersteller,
                List.of(Allergen.Erdnuss), 350, Duration.ofDays(4),
                "Vanille"
        );
        assertEquals(hersteller, k.getHersteller());
    }

    @Test
    public void shouldReturnCorrectAllergeneForGetAllergene() {
        List<Allergen> allergene = List.of(Allergen.Erdnuss);
        KremkuchenImpl k = new KremkuchenImpl(
                new BigDecimal("4.50"), new HerstellerImpl("Monte"),
                allergene, 350, Duration.ofDays(4),
                "Vanille"
        );
        assertEquals(allergene, k.getAllergene());
    }

    @Test
    public void shouldReturnCorrectNaehrwertForGetNaehrwert() {
        int naehrwert = 350;
        KremkuchenImpl k = new KremkuchenImpl(
                new BigDecimal("4.50"), new HerstellerImpl("Monte"),
                List.of(Allergen.Erdnuss), naehrwert, Duration.ofDays(4),
                "Vanille"
        );
        assertEquals(naehrwert, k.getNaehrwert());
    }

    @Test
    public void shouldReturnCorrectHaltbarkeitForGetHaltbarkeit() {
        Duration haltbarkeit = Duration.ofDays(4);
        KremkuchenImpl k = new KremkuchenImpl(
                new BigDecimal("4.50"), new HerstellerImpl("Monte"),
                List.of(Allergen.Erdnuss), 350, haltbarkeit,
                "Vanille"
        );
        assertEquals(haltbarkeit, k.getHaltbarkeit());
    }

    @Test
    public void shouldReturnDefaultFachnummerForGetFachnummer() {
        KremkuchenImpl k = new KremkuchenImpl(
                new BigDecimal("4.50"), new HerstellerImpl("Monte"),
                List.of(Allergen.Erdnuss), 350, Duration.ofDays(4),
                "Vanille"
        );
        assertEquals(-1, k.getFachnummer());  // -1 because no Fachnummer set yet
    }

    @Test
    public void shouldReturnNullForGetInspektionsdatumBecauseItsNotSet() {
        KremkuchenImpl k = new KremkuchenImpl(
                new BigDecimal("4.50"), new HerstellerImpl("Monte"),
                List.of(Allergen.Erdnuss), 350, Duration.ofDays(4),
                "Vanille"
        );
        assertNull(k.getInspektionsdatum());  // inspektionsdatum nicht im Konstruktor initialisiert
    }

    @Test
    public void shouldThrowIllegalArgumentBecauseFachnummerIsNegative() {
        KremkuchenImpl k = new KremkuchenImpl(
                new BigDecimal("4.50"), new HerstellerImpl("Monte"),
                List.of(Allergen.Erdnuss), 350, Duration.ofDays(4),
                "Vanille"
        );
        assertThrows(IllegalArgumentException.class, () -> k.setFachnummer(-5)
        );
    }

    @Test
    public void shouldReturnCorrectFachnummerBecauseItWasSet() {
        KremkuchenImpl k = new KremkuchenImpl(
                new BigDecimal("4.50"), new HerstellerImpl("Monte"),
                List.of(Allergen.Erdnuss), 350, Duration.ofDays(4),
                "Vanille"
        );
        int i = 1;
        k.setFachnummer(i);
        assertEquals(i,k.getFachnummer());
    }

    @Test
    public void shouldThrowNullPointerBecauseInspektionsdatumIsNull() {
        KremkuchenImpl k = new KremkuchenImpl(
                new BigDecimal("4.50"), new HerstellerImpl("Monte"),
                List.of(Allergen.Erdnuss), 350, Duration.ofDays(4),
                "Vanille"
        );
        assertThrows(NullPointerException.class, () -> k.setInspektionsdatum(null));
    }

    @Test
    public void shouldReturnCorrectInspektionsdatumBecauseItWasSet() {
        KremkuchenImpl k = new KremkuchenImpl(
                new BigDecimal("4.50"), new HerstellerImpl("Monte"),
                List.of(Allergen.Erdnuss), 350, Duration.ofDays(4),
                "Vanille"
        );
        Date now = new Date();
        k.setInspektionsdatum(now);
        assertEquals(now, k.getInspektionsdatum());
    }

    @Test
    public void shouldThrowNullPointerBecauseEinfuegedatumIsNull() {
        KremkuchenImpl k = new KremkuchenImpl(
                new BigDecimal("4.50"), new HerstellerImpl("Monte"),
                List.of(Allergen.Erdnuss), 350, Duration.ofDays(4),
                "Vanille"
        );
        assertThrows(NullPointerException.class, () -> k.setEinfuegedatum(null));
    }

    @Test
    public void shouldReturnCorrectEinfuegedatumBecauseItWasSet() {
        KremkuchenImpl k = new KremkuchenImpl(
                new BigDecimal("4.50"), new HerstellerImpl("Monte"),
                List.of(Allergen.Erdnuss), 350, Duration.ofDays(4),
                "Vanille"
        );
        Date now = new Date();
        k.setEinfuegedatum(now);
        assertEquals(now, k.getEinfuegedatum());
    }

    @Test
    public void shouldReturnCorrectToString() {
        HerstellerImpl hersteller = new HerstellerImpl("Monte");
        Date einfuegedatum = new Date();
        Date inspektionsdatum = new Date();
        KremkuchenImpl k = new KremkuchenImpl(
                new BigDecimal("4.50"),
                hersteller,
                List.of(Allergen.Erdnuss, Allergen.Gluten),
                350,
                Duration.ofDays(4),
                "Vanille"
        );
        k.setFachnummer(1);
        k.setEinfuegedatum(einfuegedatum);
        k.setInspektionsdatum(inspektionsdatum);

        String expected = "KremkuchenImpl (" +
                "fachnummer: 1" +
                ", einfuegedatum: " + einfuegedatum +
                ", preis: 4.50" +
                ", inspektionsdatum: " + inspektionsdatum +
                ", hersteller: Monte" +
                ", allergene: [Erdnuss, Gluten]" +
                ", naehrwert: 350" +
                ", haltbarkeit: PT96H" +
                ')';

        assertEquals(expected, k.toString());
    }

}
