package com.example.canals.exceptions;

public class NullValuesException extends RuntimeException {

    public NullValuesException(String message) {
        super(message);
    }

    public NullValuesException(Exception e) {
        super(e);
    }
}
