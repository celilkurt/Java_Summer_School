package exception;

public class RecordsNotFoundException extends Exception {

    private static final long serialVersionUID = -2872694086602732648L;

    public RecordsNotFoundException( String message) {
        super(message);
    }

    RecordsNotFoundException( String message, String cause) {
        super(message, new Throwable(cause));
    }

    @Override
    public String toString() {
        return String.format("RecordsNotFoundException: " + getMessage());
    }

}