package event;

import java.util.List;

public class AddHerstellerEvent implements CLIEvent {
    private List<String> args;

    public AddHerstellerEvent(List<String> arguments){
        if (arguments == null) throw new NullPointerException("args ist null");
        this.args = args;
    }

    public List<String> getArguments(){
        return args;
    }
}
