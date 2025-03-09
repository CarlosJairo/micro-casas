package com.Hogar360.casas.category.domain.exceptions;

public class NameMaxSizeExceededException extends RuntimeException {
    public NameMaxSizeExceededException(String message) {
        super(message);
    }
}
