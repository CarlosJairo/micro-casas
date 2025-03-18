//package com.Hogar360.casas.category.domain.usescases;
//
//import com.Hogar360.casas.domain.exceptions.EntityAlreadyExistsException;
//import com.Hogar360.casas.domain.model.CategoryModel;
//import com.Hogar360.casas.domain.ports.out.CategoryPersistencePort;
//import com.Hogar360.casas.domain.usescases.CategoryUseCase;
//import com.Hogar360.casas.domain.utils.constants.DomainConstants;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//class CategoryUseCaseTest {
//
//    @Mock
//    private CategoryPersistencePort categoryServicePort;
//
//    @InjectMocks
//    private CategoryUseCase categoryUseCase;
//
//    private CategoryModel testCategory;
//
//    @BeforeEach
//    void setUp() {
//        testCategory = new CategoryModel(1L, "Electrodomésticos", "Categoría de electrodomésticos para el hogar");
//    }
//
//    @Test
//    void saveCategory_ShouldThrowException_WhenCategoryAlreadyExists() {
//        when(categoryServicePort.getCategoryByName(testCategory.getName())).thenReturn(testCategory);
//
//        EntityAlreadyExistsException exception = assertThrows(
//                EntityAlreadyExistsException.class,
//                () -> categoryUseCase.saveCategory(testCategory)
//        );
//
//        assertEquals(DomainConstants.CATEGORY_ALREADY_CREATED, exception.getMessage());
//        verify(categoryServicePort, never()).saveCategory(any());
//    }
//
//    @Test
//    void saveCategory_ShouldSave_WhenCategoryDoesNotExist() {
//        when(categoryServicePort.getCategoryByName(testCategory.getName())).thenReturn(null);
//
//        categoryUseCase.saveCategory(testCategory);
//
//        verify(categoryServicePort, times(1)).saveCategory(testCategory);
//    }
//
//    @Test
//    void getCategories_ShouldReturnList_WhenCalled() {
//        List<CategoryModel> mockCategories = List.of(testCategory);
//        when(categoryServicePort.getCategories(0, 10, true)).thenReturn(mockCategories);
//
//        List<CategoryModel> result = categoryUseCase.getCategories(0, 10, true);
//
//        assertEquals(1, result.size());
//        assertEquals(1L, result.get(0).getId());
//        assertEquals("Electrodomésticos", result.get(0).getName());
//        assertEquals("Categoría de electrodomésticos para el hogar", result.get(0).getDescription());
//
//        verify(categoryServicePort, times(1)).getCategories(0, 10, true);
//    }
//}