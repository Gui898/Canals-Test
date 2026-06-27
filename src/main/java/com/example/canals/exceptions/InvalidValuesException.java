package com.example.canals.exceptions;

public class InvalidValuesException extends RuntimeException {
    public InvalidValuesException(String message) {
        super(message);
    }

    public InvalidValuesException(Exception e) {
        super(e);
    }
}
