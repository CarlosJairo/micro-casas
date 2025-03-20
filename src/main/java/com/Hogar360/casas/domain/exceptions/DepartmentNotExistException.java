package com.Hogar360.casas.domain.exceptions;

public class DepartmentNotExistException extends RuntimeException {
    public DepartmentNotExistException(String message) {
        super(message);
    }
}
