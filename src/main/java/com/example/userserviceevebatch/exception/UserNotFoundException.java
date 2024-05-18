package com.example.userserviceevebatch.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String emailIdIsNotExist) {
        super(emailIdIsNotExist);
    }
}
