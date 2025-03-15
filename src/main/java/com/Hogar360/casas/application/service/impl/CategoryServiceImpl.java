package com.Hogar360.casas.application.service.impl;

import com.Hogar360.casas.application.dto.request.SaveCategoryRequest;
import com.Hogar360.casas.application.dto.response.CategoryResponse;
import com.Hogar360.casas.application.dto.response.SaveCategoryResponse;
import com.Hogar360.casas.application.mappers.CategoryDtoMapper;
import com.Hogar360.casas.application.service.CategoryService;
import com.Hogar360.casas.domain.ports.in.CategoryServicePort;
import com.Hogar360.casas.commons.configurations.utils.Constants;
import com.Hogar360.casas.commons.configurations.utils.DateTimeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryServicePort categoryServicePort;
    private final CategoryDtoMapper categoryDtoMapper;

    @Override
    public SaveCategoryResponse saveCategory(SaveCategoryRequest saveCategoryRequest) {
        categoryServicePort.saveCategory(
                categoryDtoMapper.requestToModel(saveCategoryRequest));

        return new SaveCategoryResponse(Constants.SAVE_CATEGORY_RESPONSE_MESSAGE,
                DateTimeUtil.getCurrentTimestamp());
    }

    @Override
    public List<CategoryResponse> getCategories(Integer page, Integer size, boolean orderAsc) {
        return categoryDtoMapper.modelListToResponseList(categoryServicePort.getCategories(page, size, orderAsc));
    }
}
