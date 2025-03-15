package com.Hogar360.casas.domain.ports.out;

import com.Hogar360.casas.domain.model.CategoryModel;

import java.util.List;

public interface CategoryPersistencePort {
    void saveCategory(CategoryModel categoryModel);
    CategoryModel getCategoryByName(String categoryName);
    List<CategoryModel> getCategories(Integer page, Integer size, boolean orderAsc);
}
