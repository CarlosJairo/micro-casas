package com.Hogar360.casas.commons.configurations.utils;

public final class Constants {
    private Constants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String SAVE_CATEGORY_RESPONSE_MESSAGE = "Category created successfully.";
    public static final String SAVE_CITY_RESPONSE_MESSAGE = "City created successfully.";
    public static final String SAVE_DEPARTMENT_RESPONSE_MESSAGE = "Department created successfully.";
    public static final String PAGEABLE_FIELD_NAME = "name";

    public static final String DEFAULT_PAGEABLE_QUERY = "";
    public static final String DEFAULT_PAGEABLE_PAGE = "0";
    public static final String DEFAULT_PAGEABLE_SIZE = "10";
    public static final String DEFAULT_PAGEABLE_ORDER_ASC = "true";
}
