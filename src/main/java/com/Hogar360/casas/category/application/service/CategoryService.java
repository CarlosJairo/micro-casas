package com.Hogar360.casas.category.application.service;

import com.Hogar360.casas.category.application.dto.request.SaveCategoryRequest;
import com.Hogar360.casas.category.application.dto.response.CategoryResponse;
import com.Hogar360.casas.category.application.dto.response.SaveCategoryResponse;

import java.util.List;

public interface CategoryService {
    SaveCategoryResponse saveCategory(SaveCategoryRequest saveCategoryRequest);
    List<CategoryResponse> getCategories(Integer page, Integer size, boolean orderAsc);
}
