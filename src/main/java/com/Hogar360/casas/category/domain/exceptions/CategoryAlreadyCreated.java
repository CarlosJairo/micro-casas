package com.Hogar360.casas.category.domain.exceptions;

public class CategoryAlreadyCreated extends RuntimeException {
    public CategoryAlreadyCreated(String message) {
        super(message);
    }
}
