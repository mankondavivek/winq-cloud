package io.winq.cloud.exception;

public class UserAlreadyExistsException extends RuntimeException {
    String message;
    public UserAlreadyExistsException(String message) {
        this.message = message;
    }
}
