package model;

public class Result {
    private final boolean validation;
    private final String message;

    public Result(boolean type, String message) {
        this.validation = type;
        this.message = message;
    }

    public boolean isValid() {
        return validation;
    }

    public String getMessage() {
        return message;
    }



}
