package br.com.vintor.infrastructure.exceptions;

public class ConflictException extends RuntimeException {

    public ConflictException(String message) {
    }

    public ConflictException(String message, Throwable cause) {
        super(message, cause);
    }
}
