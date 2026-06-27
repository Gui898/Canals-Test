package com.example.canals.exceptions;

public class AddressNotFoundException extends RuntimeException {
    public AddressNotFoundException(String message) {
        super(message);
    }

    public AddressNotFoundException(Exception e) {
        super(e);
    }
}
