package automat;

import kuchen.Allergen;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TestObsttorteImpl {

    @Test
    public void shouldReturnTrueBecauseObjectWasCreatedSuccessfully() {
        ObsttorteImpl o = new ObsttorteImpl(
                new BigDecimal("6.00"), new HerstellerImpl("Monte"),
                List.of(Allergen.Gluten), 300, Duration.ofDays(5),
                "Sahne", "Erdbeere"
        );
        assertNotEquals(null, o);
    }

    @Test
    public void shouldThrowNPEBecauseObstsorteIsNull() {
        assertThrows(NullPointerException.class, () -> new ObsttorteImpl(
                new BigDecimal("6.00"), new HerstellerImpl("Monte"),
                List.of(Allergen.Gluten), 300, Duration.ofDays(5),
                "Sahne", null)
        );
    }

    @Test
    public void shouldThrowNPEBecauseKremsorteIsNull() {
        assertThrows(NullPointerException.class, () -> new ObsttorteImpl(
                new BigDecimal("6.00"), new HerstellerImpl("Monte"),
                List.of(Allergen.Gluten), 300, Duration.ofDays(5),
                null, "Erdbeere")
        );
    }

    @Test
    public void shouldThrowIllegalArgumentBecauseObstsorteIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new ObsttorteImpl(
                new BigDecimal("6.00"), new HerstellerImpl("Monte"),
                List.of(Allergen.Gluten), 300, Duration.ofDays(5),
                "Sahne", "")
        );
    }

    @Test
    public void shouldThrowIllegalArgumentBecauseKremsorteIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new ObsttorteImpl(
                new BigDecimal("6.00"), new HerstellerImpl("Monte"),
                List.of(Allergen.Gluten), 300, Duration.ofDays(5),
                "", "Erdbeere")
        );
    }

    @Test
    public void shouldReturnCorrectObstsorteForGetObstsorte() {
        String obstsorte = "Erdbeere";
        ObsttorteImpl o = new ObsttorteImpl(
                new BigDecimal("6.00"), new HerstellerImpl("Monte"),
                List.of(Allergen.Gluten), 300, Duration.ofDays(5),
                "Sahne", obstsorte
        );
        assertEquals(obstsorte, o.getObstsorte());
    }

    @Test
    public void shouldReturnCorrectKremsorteForGetKremsorte() {
        String kremsorte = "Sahne";
        ObsttorteImpl o = new ObsttorteImpl(
                new BigDecimal("6.00"), new HerstellerImpl("Monte"),
                List.of(Allergen.Gluten), 300, Duration.ofDays(5),
                kremsorte, "Erdbeere"
        );
        assertEquals(kremsorte, o.getKremsorte());
    }
}
