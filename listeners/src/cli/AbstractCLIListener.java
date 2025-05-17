package cli;

import automat.Automat;
import event.cli.contract.CLIEvent;
import event.cli.contract.CLIListener;

public abstract class AbstractCLIListener<T extends CLIEvent> implements CLIListener<T> {
    protected final Automat model;

    public AbstractCLIListener(Automat model) {
        if (model == null) throw new NullPointerException("model cannot be null");
        this.model = model;
    }

    @Override
    public void onCLIEvent(T event) {
        if (event == null) throw new NullPointerException("event is null");
    }
}
