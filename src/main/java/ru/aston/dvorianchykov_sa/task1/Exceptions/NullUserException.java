package ru.aston.dvorianchykov_sa.task1.Exceptions;

public class NullUserException extends Exception {

    public NullUserException() {
        super("User is null");
    }
}
