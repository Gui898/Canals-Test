package com.example.canals.exceptions;

public class PaymentFailedException extends RuntimeException {

    public PaymentFailedException(String message) {
        super(message);
    }

    public PaymentFailedException(Exception e) {
        super(e);
    }
}
