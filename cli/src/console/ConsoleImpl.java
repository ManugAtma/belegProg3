package console;

import console.modes.CMode;
import console.modes.InputMode;
import event.AddHerstellerEvent;
import event.AddHerstellerHandler;
import event.CLIEvent;
import observe.ObservableAutomat;

import java.util.Scanner;

public class ConsoleImpl implements Console {
    private ObservableAutomat model;
    private InputMode mode = new CMode();
    private ModeParser modeParser = new ModeParser();
    private AddHerstellerHandler addHerstellerHandler = new AddHerstellerHandler();

    public ConsoleImpl(ObservableAutomat model) {
        if (model == null) throw new NullPointerException("model ist null");
        this.model = model;
    }

    // 1.loop: enter kapazitaet... oder als run config? siehe Anforderungen
    public void execute() {

        System.out.println("welcome!");
        System.out.println("you are in create mode"); // see initialization of mode instance variable

        // parseCommand input
        while (true){

            System.out.print("> ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            // determine mode
            if (input.startsWith(":")) {
                InputMode newMode = modeParser.parse(input);
                if (newMode != null) mode = newMode; // switch mode
            }

            // keep mode, determine command
            else {
                Command command = mode.parseCommand(input);
                if (command != null) {
                    switch(command.operator){
                        case ADD_HERSTELLER:
                            CLIEvent e = new AddHerstellerEvent(command.args);
                            this.addHerstellerHandler.handle(e);
                            break;
                        default:
                            System.out.println("something went wrong"); // should be impossible to reach
                    }
                }
            }
        }
    }
}
