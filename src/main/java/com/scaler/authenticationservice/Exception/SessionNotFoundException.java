package com.scaler.authenticationservice.Exception;

public class SessionNotFoundException extends RuntimeException {
    public SessionNotFoundException(String message) {
        super(message);

    }
}
