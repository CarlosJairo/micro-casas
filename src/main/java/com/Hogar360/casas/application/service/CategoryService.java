package com.Hogar360.casas.application.service;

import com.Hogar360.casas.application.dto.request.SaveCategoryRequest;
import com.Hogar360.casas.application.dto.response.CategoryResponse;
import com.Hogar360.casas.application.dto.response.SaveCategoryResponse;

import java.util.List;

public interface CategoryService {
    SaveCategoryResponse saveCategory(SaveCategoryRequest saveCategoryRequest);
    List<CategoryResponse> getCategories(Integer page, Integer size, boolean orderAsc);
}
