package event.cli.handlers;

import event.cli.contract.CLIEvent;
import event.cli.contract.CLIHandler;
import event.cli.contract.CLIListener;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class AbstractCLIHandler<T extends CLIEvent> implements CLIHandler<T> {
    private final List<CLIListener<T>> listeners = new CopyOnWriteArrayList<>();

    public AbstractCLIHandler(CLIListener<T> listener){
        if (listener == null) throw new NullPointerException("listener is null");
        listeners.add(listener);
    }

    public boolean addCLIListener(CLIListener<T> listener){
        if (listener == null) throw new NullPointerException("listener is null");
        return listeners.add(listener);
    }

    public boolean removeCLIListener(CLIListener<T> listener){
        if (listener == null) throw new NullPointerException("listener is null");
        return listeners.remove(listener);
    }

    @Override
    public void handle(T event) {
        for (CLIListener<T> listener : listeners){
            listener.onCLIEvent(event);
        }
    }
}
