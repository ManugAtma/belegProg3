import automat.Automat;
import console.ConsoleImpl;
import console.contract.Console;
import event.cli.handlers.*;
import event.model.handlers.OutputAllergeneHandler;
import event.model.handlers.OutputHerstellerHandler;
import event.model.handlers.OutputKuchenHandler;
import listeners.cli.*;
import listeners.model.OutputAllergeneListener;
import listeners.model.OutputHerstellerListener;
import listeners.model.OutputKuchenListener;
import observer.ObserverAllergene;
import observer.ObserverKapazitaet;

public class Main {

    public static void main(String[] args) {

        Automat automat = new Automat(Integer.parseInt(args[0]));
        Console c = new ConsoleImpl(automat);

        // event system
        c.setAddHerstellerHandler(new AddHerstellerHandler(new AddHerstellerListener(automat)));
        c.setAddKuchenHandler(new AddKuchenHandler(new AddKuchenListener(automat)));

        OutputAllergeneHandler outputAllergeneHandler = new OutputAllergeneHandler(new OutputAllergeneListener());
        GetAllergeneListener getAllergeneListener = new GetAllergeneListener(automat, outputAllergeneHandler);
        c.setGetAllergeneHandler(new GetAllergeneHandler(getAllergeneListener));

        OutputKuchenHandler outputKuchenHandler = new OutputKuchenHandler(new OutputKuchenListener());
        GetKuchenListener getKuchenListener = new GetKuchenListener(automat, outputKuchenHandler);
        c.setGetKuchenHandler(new GetKuchenHandler(getKuchenListener));

        OutputHerstellerHandler outputHerstellerHandler = new OutputHerstellerHandler(new OutputHerstellerListener());
        GetHerstellerListener getHerstellerListener = new GetHerstellerListener(automat, outputHerstellerHandler);
        c.setGetHerstellerHandler(new GetHerstellerHandler(getHerstellerListener));

        c.setRemoveHerstellerHandler(new RemoveHerstellerHandler(new RemoveHerstellerListener(automat)));
        c.setRemoveKuchenHandler(new RemoveKuchenHandler(new RemoveKuchenListener(automat)));

        c.setSetInspektionsdatumHandler(new SetInspektionsdatumHandler(new SetInspektionsdatumListener(automat)));

        // observer pattern
        automat.addObserver(new ObserverAllergene(automat));
        automat.addObserver(new ObserverKapazitaet(automat));

        c.execute();
    }
}
