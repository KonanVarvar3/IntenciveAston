package ru.aston.dvorianchykov_sa.task1.Exceptions;

public class IncorrectUserAgeException extends Exception {

    public IncorrectUserAgeException(int age) {
        super(String.format("Incorrect user age: %d", age));
    }
}
