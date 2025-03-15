package com.Hogar360.casas.domain.exceptions;

public class NameMaxSizeExceededException extends RuntimeException {
    public NameMaxSizeExceededException(String message) {
        super(message);
    }
}
