package com.Hogar360.casas.category.domain.usescases;

import com.Hogar360.casas.category.domain.exceptions.CategoryAlreadyCreated;
import com.Hogar360.casas.category.domain.model.CategoryModel;
import com.Hogar360.casas.category.domain.ports.in.CategoryServicePort;
import com.Hogar360.casas.category.domain.ports.out.CategoryPersistencePort;
import com.Hogar360.casas.category.domain.utils.constants.DomainConstants;

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
            throw new CategoryAlreadyCreated(DomainConstants.CATEGORY_ALREADY_CREATED);
        }

        categoryPersistencePort.saveCategory(categoryModel);
    }

    @Override
    public List<CategoryModel> getCategories(Integer page, Integer size, boolean orderAsc) {
        return categoryPersistencePort.getCategories(page, size, orderAsc);
    }
}
