package automat;

import kuchen.Allergen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import verwaltung.Hersteller;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


public class TestAutomatFunctionality {

    Automat automat;

    @BeforeEach
    public void setUp() {
        automat = new Automat(2);
    }


    // 2 Mockito tests
/*
    @Test
    public void shouldCallSetFachnummerBecauseKuchenIsAdded() {

        Hersteller hersteller = new HerstellerImpl("Monte");
        automat.addHersteller(hersteller);
        AbstractKuchen mockKuchen = Mockito.mock(AbstractKuchen.class);
        Mockito.when(mockKuchen.getHersteller()).thenReturn(hersteller); //

        automat.addKuchen(mockKuchen);
        Mockito.verify(mockKuchen).setFachnummer(0);
    }

    @Test
    public void shouldCallSetEinfuegedatumBecauseKuchenIsAdded() {

        Hersteller hersteller = new HerstellerImpl("Monte");
        automat.addHersteller(hersteller);
        AbstractKuchen mockKuchen = Mockito.mock(AbstractKuchen.class);
        Mockito.when(mockKuchen.getHersteller()).thenReturn(hersteller);
        Mockito.when(mockKuchen.getAllergene()).thenReturn(List.of(Allergen.Erdnuss));

        automat.addKuchen(mockKuchen);
        Mockito.verify(mockKuchen).setEinfuegedatum(Mockito.any(Date.class));
    }
    */

    // JUnit tests

    // addKuchen

    @Test
    public void shouldReturnTrueBecauseKuchenWasAdded() {

        Hersteller monte = new HerstellerImpl("Monte");
        automat.addHersteller(monte);

        assertTrue(automat.addKuchen("Kremkuchen", new BigDecimal("4.50"),
                monte, List.of(Allergen.Erdnuss),
                350, Duration.ofDays(4),
                "Vanille", null));
    }


    // TODO: correct this test
    /*@Test
    public void shouldIncrementNumberOfKuchenInAutomatBecauseOneIsAdded() {
        Hersteller monte = new HerstellerImpl("Monte");
        automat.addHersteller(monte);
        automat.addKuchen("Kremkuchen", new BigDecimal("4.50"),
                monte, List.of(Allergen.Erdnuss),
                350, Duration.ofDays(4),
                "Vanille", null);

        assertEquals(1, automat.getAlleKuchenMap().size());
    }*/


    @Test
    public void shouldReturnTrueBecauseKuchenWithAllergenGlutenIsAdded() {
        Hersteller monte = new HerstellerImpl("Monte");
        automat.addHersteller(monte);

        automat.addKuchen("Kremkuchen", new BigDecimal("4.50"),
                monte, List.of(Allergen.Gluten),
                350, Duration.ofDays(4),
                "Vanille", null);

        assertTrue(automat.getVorhandeneAllergeneList().contains(Allergen.Gluten));
    }

    @Test
    public void shouldSetNumberOfKuchenByMonteToOne() {
        Hersteller monte = new HerstellerImpl("Monte");
        automat.addHersteller(monte);

        automat.addKuchen("Kremkuchen", new BigDecimal("4.50"),
                monte, List.of(Allergen.Gluten),
                350, Duration.ofDays(4),
                "Vanille", null);

        Map.Entry<Hersteller, Integer> pair = new AbstractMap.SimpleEntry<>(monte, 1);
        assertTrue(automat.getAlleHersteller().contains(pair));
    }

    // TODO: correct this test
   /* @Test
    public void shouldReturnCorrectFachnummerForAddedKuchen() {
        Hersteller monte = new HerstellerImpl("Monte");
        automat.addHersteller(monte);

        automat.addKuchen("Obstkuchen",  new BigDecimal("4.50"),
                monte, List.of(Allergen.Gluten),
                350, Duration.ofDays(4),
                "Vanille", null);

        assertEquals(0, automat.getAlleKuchenMap().get(0).getFachnummer());
    }*/


    @Test
    public void shouldNotAddKuchenBecauseItsHerstellerDoesntExist() {

        assertFalse(automat.addKuchen("Obsttorte", new BigDecimal("4.50"),
                new HerstellerImpl("Monte"), List.of(Allergen.Gluten),
                350, Duration.ofDays(4),
                "Vanille", "Erdbeere"));
    }

    @Test
    public void shouldNotAddKuchenBecauseMaxKapazitaetIsReached() {
        Hersteller droetker = new HerstellerImpl("DrOetker");
        automat.addHersteller(droetker);

        automat.addKuchen("Obsttorte", new BigDecimal("6.00"),
                droetker, List.of(Allergen.Sesamsamen),
                400, Duration.ofDays(3),
                "Schoko", "Kirsche");
        automat.addKuchen("Obsttorte", new BigDecimal("6.00"),
                droetker, List.of(Allergen.Sesamsamen),
                400, Duration.ofDays(3),
                "Schoko", "Kirsche");

        assertFalse(automat.addKuchen("Obsttorte", new BigDecimal("6.00"),
                droetker, List.of(Allergen.Sesamsamen),
                400, Duration.ofDays(3),
                "Schoko", "Kirsche"));
    }

    @Test
    public void shouldThrowNPEBecauseKuchenIsNull() {
        assertThrows(NullPointerException.class, () -> automat.addKuchen(null, new BigDecimal("6.00"),
                new HerstellerImpl("DrOetker"), List.of(Allergen.Sesamsamen),
                400, Duration.ofDays(3),
                "Schoko", "Kirsche"));
    }

/*
// removeKuchen

    @Test
    public void shouldRemoveKuchenAndReturnIt() {
        Hersteller droetker = new HerstellerImpl("DrOetker");
        ObsttorteImpl obsttorte = new ObsttorteImpl(
                new BigDecimal("6.00"),
                droetker, List.of(Allergen.Sesamsamen),
                400, Duration.ofDays(3),
                "Schoko", "Kirsche"
        );
        automat.addHersteller(droetker);
        automat.addKuchen(obsttorte);

        assertEquals(obsttorte, automat.removeKuchen(0));
    }

    @Test
    public void shouldDecrementNumberOfKuchenBecauseOneIsRemoved() {
        Hersteller droetker = new HerstellerImpl("DrOetker");
        ObsttorteImpl obsttorte = new ObsttorteImpl(
                new BigDecimal("6.00"),
                droetker, List.of(Allergen.Sesamsamen),
                400, Duration.ofDays(3),
                "Schoko", "Kirsche"
        );
        automat.addHersteller(droetker);
        automat.addKuchen(obsttorte);
        automat.removeKuchen(0);

        assertEquals(0, automat.getAlleKuchenMap().size());
    }

    @Test
    public void shouldDecrementAllergenGlutenBecauseOneKuchenIsRemoved() {
        Hersteller monte = new HerstellerImpl("Monte");
        KremkuchenImpl kremkuchen = new KremkuchenImpl(
                new BigDecimal("4.50"),
                monte, List.of(Allergen.Gluten),
                350, Duration.ofDays(4),
                "Vanille"
        );
        automat.addHersteller(monte);
        automat.addKuchen(kremkuchen);
        automat.removeKuchen(0);

        assertEquals(0, automat.getAlleAllergeneMap().get(Allergen.Gluten));

    }

    @Test
    public void shouldThrowIllegalArgumentBecauseOfInvalidFachnummer() {
        assertThrows(IllegalArgumentException.class, () -> automat.removeKuchen(5));
    }

    @Test
    public void shouldReturnNullBecauseThereIsNoKuchenInFach() {
        Hersteller monte = new HerstellerImpl("Monte");
        KremkuchenImpl kremkuchen = new KremkuchenImpl(
                new BigDecimal("4.50"),
                monte, List.of(Allergen.Gluten),
                350, Duration.ofDays(4),
                "Vanille"
        );
        automat.addHersteller(monte);
        automat.addKuchen(kremkuchen);

        assertNull(automat.removeKuchen(1));
    }


// getAlleKuchenList und getAlleKuchen

    @Test
    public void shouldReturnListOfAddedKuchenOfSizeOne() {
        Hersteller monte = new HerstellerImpl("Monte");
        KremkuchenImpl kremkuchen1 = new KremkuchenImpl(
                new BigDecimal("4.50"),
                monte, List.of(Allergen.Gluten),
                350, Duration.ofDays(4),
                "Vanille"
        );
        KremkuchenImpl kremkuchen2 = new KremkuchenImpl(
                new BigDecimal("4.50"),
                monte, List.of(Allergen.Gluten),
                350, Duration.ofDays(4),
                "Vanille"
        );
        automat.addHersteller(monte);
        automat.addKuchen(kremkuchen1);
        automat.addKuchen(kremkuchen2);

        assertEquals(2, automat.getAlleKuchenList().size());
    }

    @Test
    public void shouldReturnMapOfAddedKuchenOfSizeOne() {
        Hersteller monte = new HerstellerImpl("Monte");
        KremkuchenImpl kremkuchen = new KremkuchenImpl(
                new BigDecimal("4.50"),
                monte, List.of(Allergen.Gluten),
                350, Duration.ofDays(4),
                "Vanille"
        );
        automat.addHersteller(monte);
        automat.addKuchen(kremkuchen);

        assertEquals(1, automat.getAlleKuchenMap().size());
    }

    @Test
    public void shouldReturnListOfAddedKremkuchenOfSizeOne() {
        Hersteller monte = new HerstellerImpl("Monte");
        KremkuchenImpl kremkuchen = new KremkuchenImpl(
                new BigDecimal("4.50"),
                monte, List.of(Allergen.Gluten),
                350, Duration.ofDays(4),
                "Vanille"
        );
        Hersteller droetker = new HerstellerImpl("droetker");
        ObsttorteImpl obsttorte = new ObsttorteImpl(
                new BigDecimal("6.00"),
                droetker, List.of(Allergen.Sesamsamen),
                400, Duration.ofDays(3),
                "Schoko", "Kirsche"
        );
        automat.addHersteller(droetker);
        automat.addHersteller(monte);
        automat.addKuchen(obsttorte);
        automat.addKuchen(kremkuchen);

        assertEquals(1, automat.getAlleKuchen("Kremkuchen").size());
    }

    @Test
    public void shouldThrowNPEBecauseTypeIsNull() {
        assertThrows(NullPointerException.class, () -> automat.getAlleKuchen(null));
    }

    @Test
    public void shouldThrowIllegalArgumentBecauseTypeIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> automat.getAlleKuchen(""));
    }

    @Test
    public void shouldReturnCorrectNumberOfKuchenAfterOneIsRemoved() {
        Hersteller monte = new HerstellerImpl("Monte");
        KremkuchenImpl kremkuchen = new KremkuchenImpl(
                new BigDecimal("4.50"),
                monte, List.of(Allergen.Gluten),
                350, Duration.ofDays(4),
                "Vanille"
        );
        automat.addHersteller(monte);
        automat.addKuchen(kremkuchen);
        automat.removeKuchen(0);

        assertEquals(0, automat.getAlleKuchenMap().size());
    }

    @Test
    public void shouldReturnEmptyKuchenListBecauseNoKuchenInAutomat() {
        Hersteller monte = new HerstellerImpl("Monte");
        KremkuchenImpl kremkuchen = new KremkuchenImpl(
                new BigDecimal("4.50"),
                monte, List.of(Allergen.Gluten),
                350, Duration.ofDays(4),
                "Vanille"
        );
        automat.addHersteller(monte);
        automat.addKuchen(kremkuchen);
        automat.removeKuchen(0);

        assertTrue(automat.getAlleKuchenMap().isEmpty());
    }


// addHersteller

    @Test
    public void shouldAddHerstellerSuccessfully() {
        Hersteller monte = new HerstellerImpl("Monte");
        assertTrue(automat.addHersteller(monte));
    }

    @Test
    public void shouldThrowNPEBecauseHerstellerIsNull() {
        assertThrows(NullPointerException.class, () -> automat.addHersteller(null));
    }

    @Test
    public void shouldReturnFalseBecauseHerstellerExistsAlready() {
        automat.addHersteller(new HerstellerImpl("Monte"));
        assertFalse(automat.addHersteller(new HerstellerImpl("Monte")));
    }


// removeHersteller

    @Test
    public void shouldRemoveHerstellerAndReturnIt() {
        Hersteller monte = new HerstellerImpl("Monte");
        automat.addHersteller(monte);
        assertEquals(monte, automat.removeHersteller(monte));
    }

    @Test
    public void shouldDecrementNumberOfHerstellerByOne() {
        Hersteller monte = new HerstellerImpl("Monte");
        automat.addHersteller(monte);
        automat.removeHersteller(monte);
        assertEquals(0, automat.getAlleHersteller().size());
    }

    @Test
    public void shouldThrowNPEBecauseHerstellerArgumentIsNull() {
        assertThrows(NullPointerException.class, () -> automat.removeHersteller(null));
    }

    @Test
    public void shouldReturnNullBecauseHerstellerDoesntExistInAutomat() {
        assertNull(automat.removeHersteller(new HerstellerImpl("Monte")));
    }


    // getAlleHersteller

    @Test
    public void shouldReturnCorrectNumberOfAddedHerstellerInAutomat() {
        Hersteller monte = new HerstellerImpl("Monte");
        Hersteller bioland = new HerstellerImpl("bioland");
        automat.addHersteller(monte);
        automat.addHersteller(bioland);

        assertEquals(2, automat.getAlleHersteller().size());
    }

    @Test
    public void shouldReturnNumberHerstellerAfterOneIsRemoved() {
        Hersteller monte = new HerstellerImpl("Monte");
        Hersteller bioland = new HerstellerImpl("bioland");
        automat.addHersteller(monte);
        automat.addHersteller(bioland);
        automat.removeHersteller(bioland);

        assertEquals(1, automat.getAlleHersteller().size());
    }

    @Test
    public void shouldReturnEmptyHerstellerSetBecauseNoHerstellerInAutomat() {
        assertTrue(automat.getAlleHersteller().isEmpty());
    }


    // getVorhandeneAllergeneList, getNichtVorhandeneAllergeneList und getAlleAllergeneMap
    @Test
    public void shouldReturnTrueBecauseAllergenGlutenIsVorhanden() {
        Hersteller monte = new HerstellerImpl("Monte");
        KremkuchenImpl kremkuchen = new KremkuchenImpl(
                new BigDecimal("4.50"),
                monte, List.of(Allergen.Gluten),
                350, Duration.ofDays(4),
                "Vanille"
        );
        automat.addHersteller(monte);
        automat.addKuchen(kremkuchen);

        assertTrue(automat.getVorhandeneAllergeneList().contains(Allergen.Gluten));
    }

    @Test
    public void shouldReturnFalseBecauseAllergenGlutenWasRemoved() {
        Hersteller monte = new HerstellerImpl("Monte");
        KremkuchenImpl kremkuchen = new KremkuchenImpl(
                new BigDecimal("4.50"),
                monte, List.of(Allergen.Gluten),
                350, Duration.ofDays(4),
                "Vanille"
        );
        automat.addHersteller(monte);
        automat.addKuchen(kremkuchen);
        automat.removeKuchen(0);

        assertFalse(automat.getVorhandeneAllergeneList().contains(Allergen.Gluten));
    }

    @Test
    public void shouldReturnTrueBecauseAllergenErdnussIsNichtVorhanden() {
        assertTrue(automat.getNichtVorhandeneAllergeneList().contains(Allergen.Erdnuss));
    }

    @Test
    public void shouldReturnFalseBecauseAllergenErdnussIsVorhanden() {
        Hersteller monte = new HerstellerImpl("Monte");
        KremkuchenImpl kremkuchen = new KremkuchenImpl(
                new BigDecimal("4.50"),
                monte, List.of(Allergen.Erdnuss),
                350, Duration.ofDays(4),
                "Vanille"
        );
        automat.addHersteller(monte);
        automat.addKuchen(kremkuchen);
        assertFalse(automat.getNichtVorhandeneAllergeneList().contains(Allergen.Erdnuss));
    }

    @Test
    public void shouldReturnOneForAllergenErdnussInMap() {
        Hersteller monte = new HerstellerImpl("Monte");
        KremkuchenImpl kremkuchen = new KremkuchenImpl(
                new BigDecimal("4.50"),
                monte, List.of(Allergen.Erdnuss),
                350, Duration.ofDays(4),
                "Vanille"
        );
        automat.addHersteller(monte);
        automat.addKuchen(kremkuchen);

        assertEquals(1, automat.getAlleAllergeneMap().get(Allergen.Erdnuss));
    }

    @Test
    public void shouldReturnEmptyAllergeneListBecauseNoneExistInAutomat() {
        assertTrue(automat.getVorhandeneAllergeneList().isEmpty());
    }


// setInspektionsdatum

    @Test
    public void shouldReturnTrueBecauseInpektionsdatumWasSet() {
        Hersteller monte = new HerstellerImpl("Monte");
        KremkuchenImpl kremkuchen = new KremkuchenImpl(
                new BigDecimal("4.50"),
                monte, List.of(Allergen.Erdnuss),
                350, Duration.ofDays(4),
                "Vanille"
        );
        automat.addHersteller(monte);
        automat.addKuchen(kremkuchen);
        Date datum = new Date();
        automat.setInspektionsdatum(0, datum);

        assertEquals(datum, automat.getAlleKuchenMap().get(0).getInspektionsdatum());
    }


    @Test
    public void shouldThrowNPEBecauseGivenDatumIsNull() {
        assertThrows(NullPointerException.class, () -> automat.setInspektionsdatum(0, null));
    }

    @Test
    public void shouldReturnFalseBecauseFachDoesNotExist() {
        assertFalse(automat.setInspektionsdatum(0, new Date()));
    }


// getKapazitaet

    @Test
    public void shouldReturnKapazitaetOfTwo() {
        assertEquals(2, automat.getKapazitaet());
    }*/
}

