package com.Hogar360.casas.domain.exceptions;

public class CategoryAlreadyCreated extends RuntimeException {
    public CategoryAlreadyCreated(String message) {
        super(message);
    }
}
