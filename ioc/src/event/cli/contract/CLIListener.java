package event.cli.contract;

public interface CLIListener<T extends CLIEvent> {
    void onCLIEvent(T event);
}
