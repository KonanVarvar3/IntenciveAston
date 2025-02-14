package ru.aston.dvorianchykov_sa.task2.constants;

public enum Messages {
    OK("OK"),
    TRY_AGAIN("Please, try again"),
    NULL_ARRAY("The array is null!"),
    EMPTY_ARRAY("The array is empty!");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
