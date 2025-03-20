package com.Hogar360.casas.domain.utils.constants;

public final class DomainConstants {
    public  DomainConstants () {
        throw new IllegalStateException("Utility class");
    }

    public static final String FIELD_NAME_EMPTY_MESSAGE = "The field 'name' cannot be empty.";
    public static final String FIELD_DESCRIPTION_EMPTY_MESSAGE = "The field 'description' cannot be empty.";
    public static final String FIELD_NAME_NULL_MESSAGE = "Field 'name' can not be null";
    public static final String FIELD_DESCRIPTION_NULL_MESSAGE = "Field 'description' can not be null";

    public static final String ENTITY_ALREADY_CREATED = "A %s with this name already exists.";
}
