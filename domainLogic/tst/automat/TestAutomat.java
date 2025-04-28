package automat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TestAutomat {

    Automat automat;

    @BeforeEach
    public void setUp() {
        automat = new Automat(2);
    }

    // TODO 2 Mockito tests

    @Test
    public void shouldThrowIllegalArgumentBecauseKapazitaetIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> new Automat(-3));
    }

    @Test
    public void shouldReturnTrueBecauseObjectWasCreatedSuccesfully() {
        Automat k = new Automat(1);
        assertNotEquals(null, k);
    }



    @Test
    public void shouldAddKuchenSuccessfully() {}

    @Test
    public void shouldIncrementNumberOfKuchenInAutomatBecauseOneIsAdded() {}

    @Test
    public void shouldIncrementAllergenGlutenByOneBecauseKuchenIsAdded() {}

    @Test
    public void shouldIncrementHerstellerCountByOneBecauseKuchenIsAdded() {}

    @Test
    public void shouldReturnCorrectFachnummerForAddedKuchen(){}

    @Test
    public void shouldReturnCorrectEinfugedatumForAddedKuchen(){}

    @Test
    public void shouldNotAddKuchenBecauseItsHerstellerDoesntExist() {}

    @Test
    public void shouldNotAddKuchenBecauseMaxKapazitaetIsReached() {}

    @Test
    public void shouldThrowNPEBecauseKuchenIsNull() {}



    @Test
    public void shouldRemoveKuchenAndReturnIt() {}

    @Test
    public void shouldDecrementNumberOfKuchenBecauseOneIsRemoved() {}

    @Test
    public void shouldDecrementAllergenGlutenBecauseOneKuchenIsRemoved() {}

    @Test
    public void shouldNotRemoveKuchenBecauseOfInvalidFachnummer() {}

    @Test
    public void shouldReturnNullBecauseThereIsNoKuchenInFach() {}



    @Test
    public void shouldReturnCorrectNumberOfAddedKuchen() {}

    @Test
    public void shouldReturnCorrectNumberOfAddedKuchenByHerstellerMonte() {
        // Monte as Parameter
    }

    @Test
    public void shouldThrowNPEBecauseHerstellerIsNull(){}

    @Test
    public void shouldReturnCorrectNumberOfKuchenAfterOneIsRemoved() {}

    @Test
    public void shouldReturnEmptyKuchenListBecauseNoKuchenInAutomat() {}



    @Test
    public void shouldAddHerstellerSuccessfully() {}

    @Test
    public void shouldNotAddHerstellerBecauseItIsNull() {}

    @Test
    public void shouldReturnFalseBecauseHerstellerExistsAlready() {}



    @Test
    public void shouldRemoveHerstellerAndReturnIt() {}

    @Test
    public void shouldDecrementNumberOfHerstellerInAutomatBecauseOneIsRemoved() {}

    @Test
    public void shouldNotRemoveHerstellerBecauseItIsNull() {}

    @Test
    public void shouldReturnNullBecauseHerstellerDoesntExistInAutomat() {}



    @Test
    public void shouldReturnNumberOfAddedHerstellerInAutomat() {}

    @Test
    public void shouldReturnNumberHerstellerAfterOneIsRemoved() {}

    @Test
    public void shouldReturnEmptyHerstellerSetBecauseNoHerstellerInAutomat() {}




    @Test
    public void shouldReturnTrueBecauseAllergenGlutenIsVorhanden() {}

    @Test
    public void shouldReturnFalseBecauseAllergenGlutenWasRemoved() {}

    @Test
    public void shouldReturnTrueBecauseAllergenErdnussIsNichtVorhanden() {}

    @Test
    public void shouldReturnFalseBecauseAllergenErdnussIsNichtVorhanden() {}

    @Test
    public void shouldReturnEmptyAllergeneListBecauseNoneExistInAutomat(){}



    @Test
    public void shouldReturnCorrectInpektionsdatumAfterSet() {}



    @Test
    public void shouldReturnKapazitaetOfTwo() {
        // kapazitaet of 2
    }
}

