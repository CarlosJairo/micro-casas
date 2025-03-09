package com.Hogar360.casas.category.domain.ports.in;

import com.Hogar360.casas.category.domain.model.CategoryModel;

import java.util.List;

public interface CategoryServicePort {
    void saveCategory(CategoryModel categoryModel);
    List<CategoryModel> getCategories(Integer page, Integer size, boolean orderAsc);
}
