package com.Hogar360.casas.domain.utils;

public class ValidationUtils {
    private ValidationUtils() {

    }

    public static void validatePaginationParams(Object page, Object size, Object orderAsc) {
        if (!(page instanceof Integer)) {
            throw new IllegalArgumentException("Page must be a valid integer.");
        }
        if (!(size instanceof Integer)) {
            throw new IllegalArgumentException("Size must be a valid integer.");
        }
        if (!(orderAsc instanceof Boolean)) {
            throw new IllegalArgumentException("orderAsc must be a valid boolean.");
        }

        int pageInt = (int) page;
        int sizeInt = (int) size;

        if (pageInt < 0) {
            throw new IllegalArgumentException("Page number cannot be negative.");
        }
        if (sizeInt <= 0) {
            throw new IllegalArgumentException("Size must be greater than zero.");
        }
    }

}
