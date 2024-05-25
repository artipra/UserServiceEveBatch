package com.example.userserviceevebatch.exception;

public class InvalidTokenException extends RuntimeException {
    public InvalidTokenException(String invalidException) {
        super(invalidException);
    }
}
