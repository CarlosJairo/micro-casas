package com.Hogar360.casas.domain.usescases;

import com.Hogar360.casas.domain.exceptions.EntityAlreadyExistsException;
import com.Hogar360.casas.domain.model.CategoryModel;
import com.Hogar360.casas.domain.ports.in.CategoryServicePort;
import com.Hogar360.casas.domain.ports.out.CategoryPersistencePort;
import com.Hogar360.casas.domain.utils.ValidationUtils;
import com.Hogar360.casas.domain.utils.constants.DomainConstants;
import com.Hogar360.casas.domain.utils.pagination.Pagination;

import java.util.List;

public class CategoryUseCase implements CategoryServicePort {
    private final CategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(CategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void saveCategory(CategoryModel categoryModel) {
        CategoryModel category = categoryPersistencePort.getCategoryByName(categoryModel.getName());

        if (category != null) {
            throw new EntityAlreadyExistsException(DomainConstants.CATEGORY_NAME_ENTITY);
        }

        categoryPersistencePort.saveCategory(categoryModel);
    }

    @Override
    public Pagination<CategoryModel> getCategories(Integer page, Integer size, boolean orderAsc) {
        ValidationUtils.validatePaginationParams(page, size, orderAsc);
        return categoryPersistencePort.getCategories(page, size, orderAsc);
    }
}
