package com.example.canals.infra;

import com.example.canals.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(OrderNotFoundException.class)
    private ResponseEntity<RestErrorMessage> orderNotFoundException(OrderNotFoundException e){
        RestErrorMessage message = new RestErrorMessage(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, e.getMessage());
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AddressNotFoundException.class)
    private ResponseEntity<RestErrorMessage> addressNotFoundException(AddressNotFoundException e){
        RestErrorMessage message = new RestErrorMessage(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, e.getMessage());
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidValuesException.class)
    private ResponseEntity<RestErrorMessage> invalidValuesException(InvalidValuesException e){
        RestErrorMessage message = new RestErrorMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST, e.getMessage());
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PaymentFailedException.class)
    private ResponseEntity<RestErrorMessage> paymentFailedException(PaymentFailedException e){
        RestErrorMessage message = new RestErrorMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST, e.getMessage());
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    private ResponseEntity<RestErrorMessage> orderNotFoundException(ProductNotFoundException e){
        RestErrorMessage message = new RestErrorMessage(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, e.getMessage());
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ServerException.class)
    private ResponseEntity<RestErrorMessage> orderNotFoundException(ServerException e){
        RestErrorMessage message = new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(WarehouseNotFoundException.class)
    private ResponseEntity<RestErrorMessage> warehouseNotFoundException(WarehouseNotFoundException e){
        RestErrorMessage message = new RestErrorMessage(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, e.getMessage());
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }
}
