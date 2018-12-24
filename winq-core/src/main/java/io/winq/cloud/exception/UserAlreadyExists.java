package io.winq.cloud.exception;

public class UserAlreadyExists extends Throwable {
    String message;
    public UserAlreadyExists(String message) {
        this.message = message;
    }
}
