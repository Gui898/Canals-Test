package com.example.canals.infra;

import org.springframework.http.HttpStatus;

public record RestErrorMessage(int code, HttpStatus status, String message) {

}
