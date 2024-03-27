package exceptions;

public class DenylistedPersonException extends Exception {

    public DenylistedPersonException(String error) {
        super(error);
    }
}

