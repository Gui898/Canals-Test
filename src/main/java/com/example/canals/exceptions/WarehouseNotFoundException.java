package com.example.canals.exceptions;

public class WarehouseNotFoundException extends RuntimeException {

    public WarehouseNotFoundException(String message) {
        super(message);
    }

    public WarehouseNotFoundException(Exception e) {
        super(e);
    }
}
