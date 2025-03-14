package com.Hogar360.casas.category.application.mappers;

import com.Hogar360.casas.category.application.dto.request.SaveCategoryRequest;
import com.Hogar360.casas.category.application.dto.response.CategoryResponse;
import com.Hogar360.casas.category.domain.model.CategoryModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryDtoMapper {
    CategoryModel requestToModel(SaveCategoryRequest saveCategoryRequest);
    List<CategoryResponse> modelListToResponseList(List<CategoryModel> categoryModel);
}
