package br.com.bean.infrastructure.exceptions;

public class ConflictException extends RuntimeException {

    public ConflictException(String message) {
    }

    public ConflictException(String message, Throwable cause) {
        super(message, cause);
    }
}
