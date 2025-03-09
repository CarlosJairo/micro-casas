package com.Hogar360.casas.category.infrastructure.mappers;

import com.Hogar360.casas.category.domain.model.CategoryModel;
import com.Hogar360.casas.category.infrastructure.entities.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "string")
public interface CategoryEntityMapper {
    CategoryEntity modelToEntity(CategoryModel categoryModel);
    CategoryModel entityToModel(CategoryEntity categoryEntity);
}
