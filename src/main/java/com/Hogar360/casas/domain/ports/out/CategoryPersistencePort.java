package com.Hogar360.casas.domain.ports.out;

import com.Hogar360.casas.domain.model.CategoryModel;
import com.Hogar360.casas.domain.utils.pagination.Pagination;

import java.util.List;

public interface CategoryPersistencePort {
    void saveCategory(CategoryModel categoryModel);
    CategoryModel getCategoryByName(String categoryName);
    Pagination<CategoryModel> getCategories(Integer page, Integer size, boolean orderAsc);
}
