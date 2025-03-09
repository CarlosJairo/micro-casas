package com.Hogar360.casas.category.application.service;

import com.Hogar360.casas.category.application.dto.request.SaveCategoryRequest;
import com.Hogar360.casas.category.application.dto.response.SaveCategoryResponse;

public interface CategoryService {
    SaveCategoryResponse saveCategory(SaveCategoryRequest saveCategoryRequest);
}
