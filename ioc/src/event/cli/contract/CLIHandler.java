package event.cli.contract;

public interface CLIHandler<T extends CLIEvent> {
    void handle(T e);
}
