package com.Hogar360.casas.category.domain.model;

import com.Hogar360.casas.domain.exceptions.DescriptionMaxSizeExceededException;
import com.Hogar360.casas.domain.exceptions.NameMaxSizeExceededException;
import com.Hogar360.casas.domain.model.CategoryModel;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class CategoryModelTest {

    @Test
    void shouldCreateCategoryModelSuccessfully() {
        CategoryModel category = new CategoryModel(1L, "Casa Moderna", "Una casa con diseño moderno");
        assertThat(category).isNotNull();
        assertThat(category.getName()).isEqualTo("Casa Moderna");
        assertThat(category.getDescription()).isEqualTo("Una casa con diseño moderno");
    }

    @Test
    void shouldThrowExceptionWhenNameExceedsMaxSize() {
        String longName = "a".repeat(51);
        assertThatThrownBy(() -> new CategoryModel(1L, longName, "Descripción válida"))
                .isInstanceOf(NameMaxSizeExceededException.class);
    }

    @Test
    void shouldThrowExceptionWhenDescriptionExceedsMaxSize() {
        String longDescription = "a".repeat(91);
        assertThatThrownBy(() -> new CategoryModel(1L, "Nombre válido", longDescription))
                .isInstanceOf(DescriptionMaxSizeExceededException.class);
    }

    @Test
    void shouldThrowExceptionWhenSettingInvalidName() {
        CategoryModel category = new CategoryModel(1L, "Casa", "Descripción");
        String longName = "a".repeat(51);
        assertThatThrownBy(() -> category.setName(longName))
                .isInstanceOf(NameMaxSizeExceededException.class);
    }

    @Test
    void shouldThrowExceptionWhenSettingInvalidDescription() {
        CategoryModel category = new CategoryModel(1L, "Casa", "Descripción");
        String longDescription = "a".repeat(91);
        assertThatThrownBy(() -> category.setDescription(longDescription))
                .isInstanceOf(DescriptionMaxSizeExceededException.class);
    }
}