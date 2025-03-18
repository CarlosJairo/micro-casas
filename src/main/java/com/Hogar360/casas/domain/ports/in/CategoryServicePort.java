package com.Hogar360.casas.domain.ports.in;

import com.Hogar360.casas.domain.model.CategoryModel;
import com.Hogar360.casas.domain.utils.pagination.Pagination;

import java.util.List;

public interface CategoryServicePort {
    void saveCategory(CategoryModel categoryModel);
    Pagination<CategoryModel> getCategories(Integer page, Integer size, boolean orderAsc);
}
