package com.Hogar360.casas.domain.usescases;

import com.Hogar360.casas.domain.exceptions.EntityAlreadyExistsException;
import com.Hogar360.casas.domain.model.CategoryModel;
import com.Hogar360.casas.domain.ports.out.CategoryPersistencePort;
import com.Hogar360.casas.domain.utils.pagination.Pagination;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategoryUseCaseTest {

    private CategoryPersistencePort categoryPersistencePort;
    private CategoryUseCase categoryUseCase;

    @BeforeEach
    void setUp() {
        categoryPersistencePort = mock(CategoryPersistencePort.class);
        categoryUseCase = new CategoryUseCase(categoryPersistencePort);
    }

    @Test
    void testSaveCategory_Successful() {
        CategoryModel categoryModel = new CategoryModel(1L, "Lujo", "Descripción");
        when(categoryPersistencePort.getCategoryByName("Lujo")).thenReturn(null);

        categoryUseCase.saveCategory(categoryModel);

        verify(categoryPersistencePort).saveCategory(categoryModel);
    }

    @Test
    void testSaveCategory_AlreadyExists_ThrowsException() {
        CategoryModel categoryModel = new CategoryModel(1L, "Lujo", "Descripción");
        when(categoryPersistencePort.getCategoryByName("Lujo")).thenReturn(categoryModel);

        assertThrows(EntityAlreadyExistsException.class, () -> categoryUseCase.saveCategory(categoryModel));
        verify(categoryPersistencePort, never()).saveCategory(any());
    }

    @Test
    void testGetCategories_Successful() {
        Pagination<CategoryModel> pagination = new Pagination<>(null, 0, 0, 10, 0);
        when(categoryPersistencePort.getCategories(0, 10, true)).thenReturn(pagination);

        Pagination<CategoryModel> result = categoryUseCase.getCategories(0, 10, true);

        assertEquals(pagination, result);
        verify(categoryPersistencePort).getCategories(0, 10, true);
    }
}