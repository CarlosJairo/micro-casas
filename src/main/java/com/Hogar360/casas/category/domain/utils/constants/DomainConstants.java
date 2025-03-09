package com.Hogar360.casas.category.domain.utils.constants;

public final class DomainConstants {
    public  DomainConstants () {
        throw new IllegalStateException("Utility class");
    }

    public static final String FIELD_NAME_NULL_MESSAGE = "Field 'name' can not be null";
    public static final String FIELD_DESCRIPTION_NULL_MESSAGE = "Field 'description' can not be null";
    public static final String NAME_MAX_SIZE_EXCEEDED = "The category name cannot exceed 50 characters.";
    public static final String DESCRIPTION_MAX_SIZE_EXCEEDED = "The category description cannot exceed 90 characters.";
    public static final String CATEGORY_ALREADY_CREATED = "A category with this name already exists.";
}
