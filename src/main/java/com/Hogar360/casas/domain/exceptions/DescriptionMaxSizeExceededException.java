package com.Hogar360.casas.domain.exceptions;

public class DescriptionMaxSizeExceededException extends RuntimeException {
    public DescriptionMaxSizeExceededException(String message) {
        super(message);
    }
}
