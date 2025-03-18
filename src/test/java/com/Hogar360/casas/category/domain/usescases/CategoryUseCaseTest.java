package com.Hogar360.casas.category.domain.usescases;

import com.Hogar360.casas.domain.exceptions.DescriptionEmptyException;
import com.Hogar360.casas.domain.exceptions.DescriptionMaxSizeExceededException;
import com.Hogar360.casas.domain.exceptions.NameEmptyException;
import com.Hogar360.casas.domain.exceptions.NameMaxSizeExceededException;
import com.Hogar360.casas.domain.model.CategoryModel;
import com.Hogar360.casas.domain.utils.constants.DomainConstants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryModelTest {

    @Test
    void shouldCreateCategoryModelSuccessfully() {
        CategoryModel category = new CategoryModel(1L, "Casa Moderna", "Una casa con diseño moderno");
        assertEquals(1L, category.getId());
        assertEquals("Casa Moderna", category.getName());
        assertEquals("Una casa con diseño moderno", category.getDescription());
    }

    @Test
    void shouldThrowNameEmptyExceptionWhenNameIsEmpty() {
        NameEmptyException exception = assertThrows(NameEmptyException.class,
                () -> new CategoryModel(1L, "   ", "Descripción válida"));
        assertEquals(DomainConstants.FIELD_NAME_EMPTY_MESSAGE, exception.getMessage());
    }

    @Test
    void shouldThrowDescriptionEmptyExceptionWhenDescriptionIsEmpty() {
        DescriptionEmptyException exception = assertThrows(DescriptionEmptyException.class,
                () -> new CategoryModel(1L, "Nombre válido", "   "));
        assertEquals(DomainConstants.FIELD_DESCRIPTION_EMPTY_MESSAGE, exception.getMessage());
    }

    @Test
    void shouldThrowNameMaxSizeExceededExceptionWhenNameIsTooLong() {
        String longName = "a".repeat(51);
        NameMaxSizeExceededException exception = assertThrows(NameMaxSizeExceededException.class,
                () -> new CategoryModel(1L, longName, "Descripción válida"));
        assertEquals(DomainConstants.NAME_MAX_SIZE_EXCEEDED, exception.getMessage());
    }

    @Test
    void shouldThrowDescriptionMaxSizeExceededExceptionWhenDescriptionIsTooLong() {
        String longDescription = "b".repeat(91);
        DescriptionMaxSizeExceededException exception = assertThrows(DescriptionMaxSizeExceededException.class,
                () -> new CategoryModel(1L, "Nombre válido", longDescription));
        assertEquals(DomainConstants.DESCRIPTION_MAX_SIZE_EXCEEDED, exception.getMessage());
    }

    @Test
    void shouldThrowNameEmptyExceptionOnSetNameWithEmptyString() {
        CategoryModel category = new CategoryModel(1L, "Nombre válido", "Descripción válida");
        NameEmptyException exception = assertThrows(NameEmptyException.class,
                () -> category.setName("   "));
        assertEquals(DomainConstants.FIELD_NAME_EMPTY_MESSAGE, exception.getMessage());
    }

    @Test
    void shouldThrowNameMaxSizeExceededExceptionOnSetNameTooLong() {
        CategoryModel category = new CategoryModel(1L, "Nombre válido", "Descripción válida");
        String longName = "a".repeat(51);
        NameMaxSizeExceededException exception = assertThrows(NameMaxSizeExceededException.class,
                () -> category.setName(longName));
        assertEquals(DomainConstants.NAME_MAX_SIZE_EXCEEDED, exception.getMessage());
    }

    @Test
    void shouldThrowDescriptionEmptyExceptionOnSetDescriptionWithEmptyString() {
        CategoryModel category = new CategoryModel(1L, "Nombre válido", "Descripción válida");
        DescriptionEmptyException exception = assertThrows(DescriptionEmptyException.class,
                () -> category.setDescription("   "));
        assertEquals(DomainConstants.FIELD_DESCRIPTION_EMPTY_MESSAGE, exception.getMessage());
    }

    @Test
    void shouldThrowDescriptionMaxSizeExceededExceptionOnSetDescriptionTooLong() {
        CategoryModel category = new CategoryModel(1L, "Nombre válido", "Descripción válida");
        String longDescription = "b".repeat(91);
        DescriptionMaxSizeExceededException exception = assertThrows(DescriptionMaxSizeExceededException.class,
                () -> category.setDescription(longDescription));
        assertEquals(DomainConstants.DESCRIPTION_MAX_SIZE_EXCEEDED, exception.getMessage());
    }

    @Test
    void shouldSetNameSuccessfully() {
        CategoryModel category = new CategoryModel(1L, "Nombre válido", "Descripción válida");
        category.setName("Nuevo Nombre");
        assertEquals("Nuevo Nombre", category.getName());
    }

    @Test
    void shouldSetDescriptionSuccessfully() {
        CategoryModel category = new CategoryModel(1L, "Nombre válido", "Descripción válida");
        category.setDescription("Nueva descripción");
        assertEquals("Nueva descripción", category.getDescription());
    }
}