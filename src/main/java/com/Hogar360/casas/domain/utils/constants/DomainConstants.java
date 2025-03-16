package com.Hogar360.casas.domain.utils.constants;

public final class DomainConstants {
    public  DomainConstants () {
        throw new IllegalStateException("Utility class");
    }

    public static final String CATEGORY_NAME_ENTITY = "Category";
    public static final String DEPARTMENT_NAME_ENTITY = "Department";
    public static final String CITY_NAME_ENTITY = "Department";

    public static final String FIELD_NAME_NULL_MESSAGE = "Field 'name' can not be null";
    public static final String FIELD_DESCRIPTION_NULL_MESSAGE = "Field 'description' can not be null";
    public static final String NAME_MAX_SIZE_EXCEEDED = "The category name cannot exceed 50 characters.";
    public static final String DESCRIPTION_MAX_SIZE_EXCEEDED = "The category description cannot exceed 90 characters.";
    public static final String ENTITY_ALREADY_CREATED = "A %s with this name already exists.";
}
