package com.cinema.exception;

public class CustomerInvalidException extends RuntimeException {
    public CustomerInvalidException(String message) {
        super(message);
    }
}
