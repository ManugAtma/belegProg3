package console.contract;

import console.Operator;
import event.cli.contract.CLIHandler;

public interface Console {

    void setHandler(Operator operator, CLIHandler handler);
    void execute();
}
