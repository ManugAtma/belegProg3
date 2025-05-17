package startapp;

import automat.Automat;
import automat.HerstellerImpl;
import cli.AddHerstellerListener;
import cli.AddKuchenListener;
import cli.GetAllergeneListener;
import cli.GetKuchenListener;
import console.Operator;
import console.contract.Console;
import console.ConsoleImpl;
import event.cli.handlers.*;
import event.model.handlers.OutputAllergeneHandler;
import event.model.handlers.OutputKuchenHandler;
import model.OutputAllergeneListener;
import model.OutputKuchenListener;

public class Main {
    public static void main(String[] args) {

        // enter kapazitaet als run config, siehe Anforderungen
        Automat automat = new Automat(3);
        automat.addHersteller(new HerstellerImpl("Bob"));
        Console c = new ConsoleImpl(automat);
        c.setHandler(Operator.ADD_HERSTELLER, new AddHerstellerHandler(new AddHerstellerListener(automat)));
        c.setHandler(Operator.ADD_KUCHEN, new AddKuchenHandler(new AddKuchenListener(automat)));
        c.setHandler(Operator.GET_HERSTELLER, new GetHerstellerHandler());

        OutputAllergeneHandler outputAllergeneHandler = new OutputAllergeneHandler(new OutputAllergeneListener());
        GetAllergeneListener getAllergeneListener = new GetAllergeneListener(automat, outputAllergeneHandler);
        c.setHandler(Operator.GET_ALLERGENE,new GetAllergeneHandler(getAllergeneListener));

        OutputKuchenHandler outputKuchenHandler = new OutputKuchenHandler(new OutputKuchenListener());
        GetKuchenListener getKuchenListener = new GetKuchenListener(automat, outputKuchenHandler);
        c.setHandler(Operator.GET_KUCHEN, new GetKuchenHandler(getKuchenListener));

        c.setHandler(Operator.REMOVE_HERSTELLER, new RemoveHerstellerHandler());
        c.setHandler(Operator.REMOVE_KUCHEN, new RemoveKuchenHandler());
        c.setHandler(Operator.SET_FACHNUMMER, new SetFachnummerHandler());
        c.setHandler(Operator.SAVE, new SaveHandler());
        c.setHandler(Operator.LOAD, new LoadHandler());
        c.execute();


    }
}
