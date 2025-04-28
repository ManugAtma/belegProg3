package automat;

import kuchen.Allergen;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestObstkuchenImpl {

    @Test
    public void shouldReturnTrueBecauseObjectWasCreatedSuccessfully() {
        ObstkuchenImpl o = new ObstkuchenImpl(
                new BigDecimal("5.00"), new HerstellerImpl("Monte"),
                List.of(Allergen.Gluten), 250, Duration.ofDays(3),
                "Apfel"
        );
        assertNotEquals(null, o);
    }

    @Test
    public void shouldThrowNPEBecauseObstsorteIsNull() {
        assertThrows(NullPointerException.class, () -> new ObstkuchenImpl(
                new BigDecimal("5.00"), new HerstellerImpl("Monte"),
                List.of(Allergen.Gluten), 250, Duration.ofDays(3),
                null)
        );
    }

    @Test
    public void shouldThrowIllegalArgumentBecauseObstsorteIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new ObstkuchenImpl(
                new BigDecimal("5.00"), new HerstellerImpl("Monte"),
                List.of(Allergen.Gluten), 250, Duration.ofDays(3),
                "")
        );
    }

    @Test
    public void shouldReturnCorrectObstsorteForGetObstsorte() {
        String obstsorte = "Kirsche";
        ObstkuchenImpl o = new ObstkuchenImpl(
                new BigDecimal("5.00"), new HerstellerImpl("Monte"),
                List.of(Allergen.Gluten), 250, Duration.ofDays(3),
                obstsorte
        );
        assertEquals(obstsorte, o.getObstsorte());
    }
}
