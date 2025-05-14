package startapp;

import automat.Automat;
import automat.HerstellerImpl;
import cli.AddKuchenListener;
import console.Operator;
import console.contract.Console;
import console.ConsoleImpl;
import event.cli.events.AddKuchenEvent;
import event.cli.handlers.*;

public class Main {
    public static void main(String[] args) {

        // enter kapazitaet als run config, siehe Anforderungen
        Automat a = new Automat(3);
        a.addHersteller(new HerstellerImpl("Bob"));
        Console c = new ConsoleImpl(a);
        //c.setHandler(Operator.ADD_HERSTELLER, new AddHerstellerHandler());
        c.setHandler(Operator.ADD_KUCHEN, new AddKuchenHandler(new AddKuchenListener(a)));
        c.setHandler(Operator.GET_HERSTELLER, new GetHerstellerHandler());
        c.setHandler(Operator.GET_ALLERGENE, new GetAllergeneHandler());
        c.setHandler(Operator.GET_KUCHEN, new GetKuchenHandler());
        c.setHandler(Operator.REMOVE_HERSTELLER, new RemoveHerstellerHandler());
        c.setHandler(Operator.REMOVE_KUCHEN, new RemoveKuchenHandler());
        c.setHandler(Operator.SET_FACHNUMMER, new SetFachnummerHandler());
        c.setHandler(Operator.SAVE, new SaveHandler());
        c.setHandler(Operator.LOAD, new LoadHandler());
        c.execute();


    }
}
