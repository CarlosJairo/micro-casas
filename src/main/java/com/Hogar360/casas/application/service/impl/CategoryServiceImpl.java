package com.Hogar360.casas.application.service.impl;

import com.Hogar360.casas.application.dto.request.SaveCategoryRequest;
import com.Hogar360.casas.application.dto.response.CategoryResponse;
import com.Hogar360.casas.application.dto.response.PaginationResponse;
import com.Hogar360.casas.application.dto.response.SaveCategoryResponse;
import com.Hogar360.casas.application.mappers.CategoryDtoMapper;
import com.Hogar360.casas.application.service.CategoryService;
import com.Hogar360.casas.domain.model.CategoryModel;
import com.Hogar360.casas.domain.ports.in.CategoryServicePort;
import com.Hogar360.casas.commons.configurations.utils.Constants;
import com.Hogar360.casas.commons.configurations.utils.DateTimeUtil;
import com.Hogar360.casas.domain.utils.pagination.Pagination;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
    public PaginationResponse<CategoryResponse> getCategories(Integer page, Integer size, boolean orderAsc) {
        Pagination<CategoryModel> paginationModel = categoryServicePort.getCategories(page, size, orderAsc);

        return new PaginationResponse<>(
                categoryDtoMapper.modelListToResponseList(paginationModel.getContent()),
                paginationModel.getTotalElements(),
                paginationModel.getTotalPages(),
                paginationModel.getSize(),
                paginationModel.getNumber()
        );
    }
}
