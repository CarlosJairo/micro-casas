package com.Hogar360.casas.category.application.service.impl;

import com.Hogar360.casas.category.application.dto.request.SaveCategoryRequest;
import com.Hogar360.casas.category.application.dto.response.CategoryResponse;
import com.Hogar360.casas.category.application.dto.response.SaveCategoryResponse;
import com.Hogar360.casas.category.application.mappers.CategoryDtoMapper;
import com.Hogar360.casas.category.application.service.CategoryService;
import com.Hogar360.casas.category.domain.ports.out.CategoryPersistencePort;
import com.Hogar360.casas.commons.configurations.utils.Constants;
import com.Hogar360.casas.commons.configurations.utils.DateTimeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryPersistencePort categoryPersistencePort;
    private final CategoryDtoMapper categoryDtoMapper;

    @Override
    public SaveCategoryResponse saveCategory(SaveCategoryRequest saveCategoryRequest) {
        categoryPersistencePort.saveCategory(
                categoryDtoMapper.requestToModel(saveCategoryRequest));

        return new SaveCategoryResponse(Constants.SAVE_CATEGORY_RESPONSE_MESSAGE,
                DateTimeUtil.getCurrentTimestamp());
    }

    @Override
    public List<CategoryResponse> getCategories(Integer page, Integer size, boolean orderAsc) {
        return categoryDtoMapper.modelListToResponseList(categoryPersistencePort.getCategories(page, size, orderAsc));
    }
}
