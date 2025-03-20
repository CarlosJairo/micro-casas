package com.Hogar360.casas.domain.utils.constants;

public class CategoryDomainConstants {
    public  CategoryDomainConstants () {
        throw new IllegalStateException("Utility class");
    }

    public static final int CATEGORY_NAME_MAX_LENGTH = 50;
    public static final int CATEGORY_DESCRIPTION_MAX_LENGTH = 90;
    public static final String CATEGORY_NAME_ENTITY = "Category";
    public static final String CATEGORY_NAME_MAX_SIZE_EXCEEDED = "The category name cannot exceed 50 characters.";
    public static final String CATEGORY_DESCRIPTION_MAX_SIZE_EXCEEDED = "The category description cannot exceed 120 characters.";
}
