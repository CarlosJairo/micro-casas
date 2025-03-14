package com.Hogar360.casas.commons.configurations.utils;

public class SwaggerDocumentation {

    // Tag Descriptions
    public static final String CATEGORY_TAG = "Categories";
    public static final String CATEGORY_DESCRIPTION = "Endpoints for managing property categories";

    // Save Category
    public static final String SAVE_CATEGORY_SUMMARY = "Create a new category";
    public static final String SAVE_CATEGORY_DESCRIPTION = "Allows an administrator to create a new property category. The name must be unique and include a description.";
    public static final String SAVE_CATEGORY_SUCCESS = "Category successfully created";
    public static final String SAVE_CATEGORY_BAD_REQUEST = "Invalid request data";
    public static final String SAVE_CATEGORY_CONFLICT = "Category name already exists";

    // Get Categories
    public static final String GET_CATEGORIES_SUMMARY = "Get all categories";
    public static final String GET_CATEGORIES_DESCRIPTION = "Retrieves a paginated list of all property categories. You can specify sorting order.";
    public static final String GET_CATEGORIES_SUCCESS = "Categories retrieved successfully";

    // HTTP Status Codes
    public static final String STATUS_200 = "200";
    public static final String STATUS_201 = "201";
    public static final String STATUS_400 = "400";
    public static final String STATUS_409 = "409";
}