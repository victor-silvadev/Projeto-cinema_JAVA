package com.cinema.exception;

public class InexistingPathException extends RuntimeException {
    public InexistingPathException(String message) {
        super(message);
    }
}
