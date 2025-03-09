package com.Hogar360.casas.category.domain.exceptions;

public class DescriptionMaxSizeExceededException extends RuntimeException {
    public DescriptionMaxSizeExceededException(String message) {
        super(message);
    }
}
