package startapp;

import automat.Automat;
import console.Operator;
import console.contract.Console;
import console.ConsoleImpl;
import event.handlers.AddHerstellerHandler;
import event.handlers.AddKuchenHandler;
import observe.ObservableAutomat;

public class Main {
    public static void main(String[] args) {

        // enter kapazitaet als run config, siehe Anforderungen
        ObservableAutomat a = new Automat(3);
        Console c = new ConsoleImpl(a);
        c.setHandler(Operator.ADD_HERSTELLER, new AddHerstellerHandler());
        c.setHandler(Operator.ADD_KUCHEN, new AddKuchenHandler());
        c.execute();


    }
}
