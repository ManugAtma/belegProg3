package automat;

import kuchen.Allergen;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestKremkuchenImpl {

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
    public void shouldThrowNPEBecauseKremsorteIsNull() {

        assertThrows(NullPointerException.class, () -> new KremkuchenImpl(
                new BigDecimal("4.50"), new HerstellerImpl("Monte"),
                List.of(Allergen.Erdnuss), 350, Duration.ofDays(4),
                null)
        );
    }

    @Test
    public void shouldThrowIllegalArgumentBecauseKremsorteIsEmpty() {

        assertThrows(IllegalArgumentException.class, () -> new KremkuchenImpl(
                new BigDecimal("4.50"), new HerstellerImpl("Monte"),
                List.of(Allergen.Erdnuss), 350, Duration.ofDays(4),
                "")
        );
    }

    @Test
    public void shouldReturnCorrectKremsorteForGetKremsorte() {
        String kremsorte = "Nusscreme";
        KremkuchenImpl k = new KremkuchenImpl(
                new BigDecimal("4.50"), new HerstellerImpl("Monte"),
                List.of(Allergen.Erdnuss), 350, Duration.ofDays(4),
                kremsorte
        );
        assertEquals(kremsorte, k.getKremsorte());
    }
}
