package automat;

import org.junit.jupiter.api.Test;
import verwaltung.Hersteller;

import static org.junit.jupiter.api.Assertions.*;

public class TestHerstellerImpl {


    @Test
    public void shouldReturnTrueBecauseObjectWasCreatedSuccesfully() {
       Hersteller h = new HerstellerImpl("joe");
       assertNotEquals(h,null);
    }

    @Test
    public void shouldThrowIllegalArgumentBecauseNameIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new HerstellerImpl(null));
    }

    @Test
    public void shouldThrowIllegalArgumentBecauseNameIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new HerstellerImpl(""));
    }

    @Test
    public void shouldReturnCorrectNameForGetName() {
        String name = "Joe";
        Hersteller h = new HerstellerImpl(name);
        assertEquals(name, h.getName());
    }

    @Test
    public void shouldReturnTrueBecauseObjectsAreEqual() {
        String name = "Joe";
        Hersteller h1 = new HerstellerImpl(name);
        Hersteller h2 = new HerstellerImpl(name);
        assertTrue(h1.equals(h2));
    }

    @Test
    public void shouldReturnTrueBecauseItsTheSameObject() {
        String name = "Joe";
        Hersteller h = new HerstellerImpl(name);
        assertTrue(h.equals(h));
    }

    @Test
    public void shouldReturnFalseBecauseArgumentIsNull() {
        String name = "Joe";
        Hersteller h1 = new HerstellerImpl(name);
        Hersteller h2 = null;
        assertFalse(h1.equals(h2));
    }

    @Test
    public void shouldReturnEqualHashCodesBecauseObjectsAreEqual() {
        String name = "Joe";
        Hersteller h1 = new HerstellerImpl(name);
        Hersteller h2 = new HerstellerImpl(name);
        assertEquals(h1.hashCode(), h2.hashCode());
    }
}
