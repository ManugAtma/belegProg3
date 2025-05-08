package startapp;

import automat.Automat;
import console.Console;
import console.ConsoleImpl;

public class Main {
    public static void main(String[] args) {
        Automat a = new Automat(3);
        Console c = new ConsoleImpl(a);
        c.execute();
    }
}
