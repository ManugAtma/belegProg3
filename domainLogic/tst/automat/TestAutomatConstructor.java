package automat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TestAutomatConstructor {

    @Test
    public void shouldThrowIllegalArgumentBecauseKapazitaetIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> new Automat(-3));
    }

    @Test
    public void shouldReturnTrueBecauseObjectWasCreatedSuccesfully() {
        Automat k = new Automat(1);
        assertNotEquals(null, k);
    }
}
