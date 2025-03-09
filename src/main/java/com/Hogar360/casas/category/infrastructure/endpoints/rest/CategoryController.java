package com.Hogar360.casas.category.infrastructure.endpoints.rest;

import com.Hogar360.casas.category.application.dto.request.SaveCategoryRequest;
import com.Hogar360.casas.category.application.dto.response.CategoryResponse;
import com.Hogar360.casas.category.application.dto.response.SaveCategoryResponse;
import com.Hogar360.casas.category.application.service.CategoryService;
import com.Hogar360.casas.commons.configurations.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<SaveCategoryResponse> saveCategory(@RequestBody SaveCategoryRequest saveCategoryRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.saveCategory(saveCategoryRequest));
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getCategories(
            @RequestParam(defaultValue = Constants.ZERO) Integer page,
            @RequestParam(defaultValue = Constants.TEN) Integer size,
            @RequestParam(defaultValue = Constants.TRUE) boolean orderAsc
    ) {
        return ResponseEntity.ok(categoryService.getCategories(page, size, orderAsc));
    }
}
