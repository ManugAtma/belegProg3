package console.modes;

import console.contract.InputMode;

public abstract class AbstractInputMode implements InputMode {

    protected Integer parseStringToPositiveInt(String input, String arg) {
        int i;
        try {
            i = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println(arg + " must be an integer");
            return null;
        }
        if (i <= 0) {
            System.out.println(arg + " must be > 0");
            return null;
        }
        return i;
    }

    protected String parseLetterOnlyString(String input, String arg) {
        if (!input.matches("[a-zA-Z]+")) {
            System.out.println(arg + " name can only contain letters");
            return null;
        }
        return input;
    }
}
