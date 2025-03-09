package com.Hogar360.casas.category.application.mappers;

import com.Hogar360.casas.category.application.dto.request.SaveCategoryRequest;
import com.Hogar360.casas.category.domain.model.CategoryModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryDtoMapper {
    CategoryModel requestToModel(SaveCategoryRequest saveCategoryRequest);
}
