package com.cinema.exception;

public class AdministratorPasswordIsIncorrectException extends RuntimeException {
    public AdministratorPasswordIsIncorrectException(String message) {
        super(message);
    }
}
