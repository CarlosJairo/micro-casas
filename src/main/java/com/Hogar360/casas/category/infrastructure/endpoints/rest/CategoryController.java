package com.Hogar360.casas.category.infrastructure.endpoints.rest;

import com.Hogar360.casas.category.application.dto.request.SaveCategoryRequest;
import com.Hogar360.casas.category.application.dto.response.SaveCategoryResponse;
import com.Hogar360.casas.category.application.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<SaveCategoryResponse> saveCategory(SaveCategoryRequest saveCategoryRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.saveCategory(saveCategoryRequest));
    }
}
