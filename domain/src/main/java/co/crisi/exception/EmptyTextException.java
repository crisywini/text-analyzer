package co.crisi.exception;

public class EmptyTextException extends RuntimeException {

    private static final String EMPTY_MESSAGE_EXCEPTION = "The input is blank! Couldn't do any operation with it!";

    public EmptyTextException() {
        super(EMPTY_MESSAGE_EXCEPTION);
    }

}
