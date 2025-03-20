package com.Hogar360.casas.infrastructure.utils.constants;

public class SwaggerDescriptions {
    // ----- CATEGORY -----
    public static final String CATEGORY_TAG = "Endpoints for managing property categories";
    public static final String CATEGORY_CREATE_SUMMARY = "Create a new category";
    public static final String CATEGORY_CREATE_DESCRIPTION =
            "Creates a new property category with a unique name and a description. " +
                    "Name must be unique and up to 50 characters. Description up to 90 characters.";

    // ----- CITY -----
    public static final String CITY_TAG = "Endpoints for managing cities";
    public static final String CITY_CREATE_SUMMARY = "Create a new city";
    public static final String CITY_CREATE_DESCRIPTION =
            "Creates a new city associated with a department. " +
                    "City name up to 50 characters and description up to 120 characters.";

    // ----- DEPARTMENT -----
    public static final String DEPARTMENT_TAG = "Endpoints for managing departments";
    public static final String DEPARTMENT_CREATE_SUMMARY = "Create a new department";
    public static final String DEPARTMENT_CREATE_DESCRIPTION =
            "Creates a new department with a unique name and description. " +
                    "Name must be unique and up to 50 characters. Description up to 120 characters.";

    // ----- LOCATION -----
    public static final String LOCATION_TAG = "Endpoints for managing locations";
    public static final String LOCATION_SEARCH_SUMMARY = "Search locations by city or department";
    public static final String LOCATION_SEARCH_DESCRIPTION =
            "Search locations that match the query by city or department name. " +
                    "Supports pagination and sorting.";
    public static final String RESPONSE_200= "Locations retrieved successfully";

    // ----- COMMON RESPONSES -----
    public static final String RESPONSE_201 = "Resource created successfully";
    public static final String RESPONSE_400 = "Invalid input data";
}
