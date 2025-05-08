package console;

import console.modes.*;

public class ModeParser {


    public InputMode parse(String command){
        switch(command){
            case ":c" :
                System.out.println("you are in create mode");
                return new CMode();
            case ":r" :
                System.out.println("you are in read mode");
                return new RMode();
            case ":u" :
                System.out.println("you are in update mode");
                return new UMode();
            case ":d" :
                System.out.println("you are in delete mode");
                return new DMode();
            case ":p" :
                System.out.println("you are in persistence mode");
                return new PMode();
            case ":x" :
                System.out.println("exiting...");
                System.exit(0);
            default:
                System.out.println("no such mode available"); // list available modes?
                return null;
        }
    }
}
