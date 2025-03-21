package com.Hogar360.casas.infrastructure.endpoints.rest;

import com.Hogar360.casas.application.dto.request.SaveCategoryRequest;
import com.Hogar360.casas.application.dto.response.CategoryResponse;
import com.Hogar360.casas.application.dto.response.PaginationResponse;
import com.Hogar360.casas.application.dto.response.SaveCategoryResponse;
import com.Hogar360.casas.application.service.CategoryService;
import com.Hogar360.casas.commons.configurations.utils.Constants;
import com.Hogar360.casas.commons.configurations.utils.SwaggerDocumentation;
import com.Hogar360.casas.infrastructure.utils.constants.EndpointPaths;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(EndpointPaths.CATEGORY_BASE)
@RequiredArgsConstructor
@Tag(name = SwaggerDocumentation.CATEGORY_TAG, description = SwaggerDocumentation.CATEGORY_DESCRIPTION)
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    @Operation(summary = SwaggerDocumentation.SAVE_CATEGORY_SUMMARY, description = SwaggerDocumentation.SAVE_CATEGORY_DESCRIPTION)
    @ApiResponses(value = {
            @ApiResponse(responseCode = SwaggerDocumentation.STATUS_201, description = SwaggerDocumentation.SAVE_CATEGORY_SUCCESS),
            @ApiResponse(responseCode = SwaggerDocumentation.STATUS_400, description = SwaggerDocumentation.SAVE_CATEGORY_BAD_REQUEST),
            @ApiResponse(responseCode = SwaggerDocumentation.STATUS_400, description = SwaggerDocumentation.SAVE_CATEGORY_CONFLICT)
    })
    public ResponseEntity<SaveCategoryResponse> saveCategory(@RequestBody SaveCategoryRequest saveCategoryRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.saveCategory(saveCategoryRequest));
    }

    @GetMapping
    @Operation(summary = SwaggerDocumentation.GET_CATEGORIES_SUMMARY, description = SwaggerDocumentation.GET_CATEGORIES_DESCRIPTION)
    @ApiResponses(value = {
            @ApiResponse(responseCode = SwaggerDocumentation.STATUS_200, description = SwaggerDocumentation.GET_CATEGORIES_SUCCESS)
    })
    public ResponseEntity<PaginationResponse<CategoryResponse>> getCategories(
            @RequestParam(defaultValue = Constants.DEFAULT_PAGEABLE_PAGE) Integer page,
            @RequestParam(defaultValue = Constants.DEFAULT_PAGEABLE_SIZE) Integer size,
            @RequestParam(defaultValue = Constants.DEFAULT_PAGEABLE_ORDER_ASC) boolean orderAsc
    ) {
        return ResponseEntity.ok(categoryService.getCategories(page, size, orderAsc));
    }
}