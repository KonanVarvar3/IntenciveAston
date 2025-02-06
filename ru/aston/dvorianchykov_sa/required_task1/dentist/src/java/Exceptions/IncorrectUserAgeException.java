package Exceptions;

public class IncorrectUserAgeException extends Exception {

    public IncorrectUserAgeException(int age) {
        super(String.format("Incorrect user age: %d", age));
    }
}
