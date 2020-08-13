package day7CRUDApp.exception;

public class RecordNotFoundException extends Exception {

    private static final long serialVersionUID = -2872694086602732648L;

    public RecordNotFoundException(String message) {
        super(message);
    }

    RecordNotFoundException(String message, String cause) {
        super(message, new Throwable(cause));
    }

    @Override
    public String toString() {
        return String.format("RecordNotFoundException: " + getMessage());
    }

}