package console.modes;

import console.Operator;
import event.cli.events.SetInspektionsdatumEvent;

public class UMode extends AbstractInputMode {
    private SetInspektionsdatumEvent setFachnummerEvent;

    @Override
    public Operator parse(String input) {

        if (input.trim().isEmpty()) return null;

        Integer i = this.parseStringToPositiveInt(input, "fachnummer");
        if (i == null) return null;
        this.setFachnummerEvent = new SetInspektionsdatumEvent(i);
        return Operator.SET_FACHNUMMER;
    }

    public SetInspektionsdatumEvent getSetFachnummerEvent() {
        return setFachnummerEvent;
    }
}
