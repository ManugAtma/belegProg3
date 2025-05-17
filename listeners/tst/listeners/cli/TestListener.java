package listeners.cli;

import automat.Automat;
import automat.HerstellerImpl;
import event.cli.events.AddHerstellerEvent;
import event.cli.events.AddKuchenEvent;
import kuchen.Allergen;
import org.junit.jupiter.api.Test;
import verwaltung.Hersteller;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestListener {


    @Test
    void onCLIEvent_ReturnNotNull_WhenAddedByListenerBefore() {

        Automat automat = new Automat(3);
        AddHerstellerListener listener = new AddHerstellerListener(automat);
        String name = "Frodo";
        AddHerstellerEvent event = new AddHerstellerEvent(new HerstellerImpl(name));

        listener.onCLIEvent(event);

        assertNotNull(automat.removeHersteller(name));
    }

    @Test
    void onCLIEvent_ReturnOne_WhenAddedByListenerBefore() {

        Automat automat = new Automat(3);
        AddKuchenListener listener = new AddKuchenListener(automat);
        Hersteller bob = new HerstellerImpl("Bob");
        automat.addHersteller(bob);

        AddKuchenEvent event = new AddKuchenEvent(
                "Obstkuchen", new BigDecimal("4.99"),
                bob, List.of(Allergen.Gluten, Allergen.Erdnuss),
                450, Duration.ofDays(3), "Apfel",
                "Zimt"
        );

        listener.onCLIEvent(event);

        assertEquals(1, automat.getNumberOfKuchen());
    }
}
