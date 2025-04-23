import automat.Automat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestDomainLogic {

    Automat automat;

    @BeforeEach
    public void setUp() {
        automat = new Automat(4);
    }

    // insertFourKuchen()?

    // test contructors? -> seeehr viele NPEs

    @Test
    public void shouldAddKuchenSuccessfully() {}

    @Test
    public void shouldIncrementNumberOfKuchenInAutomatBecauseOneIsAdded() {}

    @Test
    public void shouldIncrementAllergenGlutenByOneBecauseKuchenIsAdded() {}

    @Test
    public void shouldIncrementHerstellerCountByOneBecauseKuchenIsAdded() {}

    @Test
    public void shouldAddKuchenBecasueItIsNull() {}

    @Test
    public void shouldNotAddKuchenBecauseItsHerstellerDoesntExist() {}

    @Test
    public void shouldNotAddKuchenBecauseMaxKapazitaetIsReached() {}





    @Test
    public void shouldRemoveKuchenAndReturnIt() {}

    @Test
    public void shouldDecrementNumberOfKuchenBecauseOneIsRemoved() {}

    @Test
    public void shouldDecrementAllergenGlutenBecauseOneKuchenIsRemoved() {}

    @Test
    public void shouldNotRemoveKuchenBecauseOfInvalidFachnummer() {}

    @Test
    public void shouldNotRemoveKuchenBecauseFachIsEmpty() {}



    @Test
    public void shouldReturnCorrectNumberOfAddedKuchen() {}

    @Test
    public void shouldReturnCorrectNumberOfAddedKuchenByHerstellerMonte() {
        // Monte as Parameter
    }

    @Test
    public void shouldReturnCorrectNumberOfKuchenAfterOneIsRemoved() {}




    @Test
    public void shouldAddHerstellerSuccessfully() {}

    @Test
    public void shouldNotAddHerstellerBecauseItIsNull() {}

    @Test
    public void shouldNotAddHerstellerBecauseItExistsAlready() {}



    @Test
    public void shouldRemoveHerstellerAndReturnIt() {}

    @Test
    public void shouldDecrementNumberOfHerstellerInAutomatBecauseOneIsRemoved() {}

    @Test
    public void shouldNotRemoveHerstellerBecauseItIsNull() {}

    @Test
    public void shouldNotRemoveHerstellerBecauseItDoesntExistInAutomat() {}



    @Test
    public void shouldReturnNumberOfAddedHerstellerInAutomat() {}

    @Test
    public void shouldReturnNumberHerstellerAfterOneIsRemoved() {}



    @Test
    public void shouldReturnVorhandenesAllergenGluten() {}

    @Test
    public void shouldNotReturnVorhandenesAllergenGlutenBecauseItWasRemoved() {}

    @Test
    public void shouldReturnNichtVorhandenesAllergenErdnuss() {}

    @Test
    public void shouldNotReturnNichtVorhandenesAllergenErdnuss() {}



    @Test
    public void shouldReturnCorrectInpektionsdatum() {}



    @Test
    public void shouldReturnKapazitaetOfFour() {
        // kapazitaet of 4
    }
}

