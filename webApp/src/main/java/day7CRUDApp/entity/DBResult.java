package day7CRUDApp.entity;

public class DBResult {

    private String message;
    private Object result;
    private boolean isSuccessful;

    public DBResult() {
        message = "";
        result = null;
        isSuccessful = false;
    }

    public DBResult(String message, Object result, boolean isSuccessful) {
        this.message = message;
        this.result = result;
        this.isSuccessful = isSuccessful;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public boolean isSuccessful() {
        return isSuccessful;
    }

    public void setSuccessful(boolean successful) {
        isSuccessful = successful;
    }
}
