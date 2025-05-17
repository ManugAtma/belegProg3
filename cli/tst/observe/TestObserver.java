package observe;

import observer.ObserverKapazitaet;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestObserver {

    @Test
    void update_PrintsToSysOut_WhenAbove90Percent() {

        ObservableAutomat automat = mock(ObservableAutomat.class);

        when(automat.getNumberOfKuchen()).thenReturn(9);
        when(automat.getKapazitaet()).thenReturn(10);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        new ObserverKapazitaet(automat).update();

        System.setOut(System.out);
        assertTrue(out.toString().contains("90%"));
    }

    @Test
    void update_DoesNotPrintToSysOut_WhenBelow90Percent() {

        ObservableAutomat automat = mock(ObservableAutomat.class);

        when(automat.getNumberOfKuchen()).thenReturn(5);
        when(automat.getKapazitaet()).thenReturn(10);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        new ObserverKapazitaet(automat).update();

        System.setOut(System.out);
        assertFalse(out.toString().contains("90%"));
    }
}
