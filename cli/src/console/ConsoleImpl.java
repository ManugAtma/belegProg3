package console;

import console.contract.Console;
import console.modes.CMode;
import console.contract.InputMode;
import event.cli.contract.CLIEvent;
import event.cli.contract.CLIHandler;
import observe.contract.ObservableAutomat;

import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;


public class ConsoleImpl implements Console {
    private final ObservableAutomat model;
    private final Map<Operator, CLIHandler> handlers = new ConcurrentHashMap<>();
    private final ModeParser modeParser = new ModeParser();
    private InputMode mode = new CMode();

    public ConsoleImpl(ObservableAutomat model) {
        if (model == null) throw new NullPointerException("model ist null");
        this.model = model;
    }

    @Override
    public void setHandler(Operator operator, CLIHandler handler) {
        if (operator == null || handler == null) throw new NullPointerException("operator or handler is null");
        handlers.put(operator, handler);
    }

    public void execute() {

        System.out.println("welcome!");
        System.out.println("you are in create mode"); // see initialization of mode instance variable
        Scanner scanner = new Scanner(System.in);

        // read user input
        while (true) {

            System.out.print("> ");
            String input = scanner.nextLine();

            // read mode
            if (input.startsWith(":")) {
                InputMode newMode = modeParser.parse(input);
                if (newMode != null) mode = newMode;
            }

            // read command
            else {
                Command command = mode.parseCommand(input);
                if (command != null) {
                    CLIHandler handler = handlers.get(command.getOperator()); // NPE for missing handler?
                    CLIEvent event = command.getEvent();
                    handler.handle(event);
                }
            }
        }
    }
}
