package com.Hogar360.casas.domain.usescases;

import com.Hogar360.casas.domain.exceptions.EntityAlreadyExistsException;
import com.Hogar360.casas.domain.model.DepartmentModel;
import com.Hogar360.casas.domain.ports.out.DepartmentPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DepartmentUseCaseTest {

    private DepartmentPersistencePort departmentPersistencePort;
    private DepartmentUseCase departmentUseCase;

    @BeforeEach
    void setUp() {
        departmentPersistencePort = mock(DepartmentPersistencePort.class);
        departmentUseCase = new DepartmentUseCase(departmentPersistencePort);
    }

    @Test
    void testSaveDepartment_Successful() {
        DepartmentModel departmentModel = new DepartmentModel(1L, "Antioquia", "Descripción", Collections.emptyList());
        when(departmentPersistencePort.getDepartmentByName("Antioquia")).thenReturn(null);

        departmentUseCase.save(departmentModel);

        verify(departmentPersistencePort).save(departmentModel);
    }

    @Test
    void testSaveDepartment_AlreadyExists_ThrowsException() {
        DepartmentModel departmentModel = new DepartmentModel(1L, "Antioquia", "Descripción", Collections.emptyList());
        when(departmentPersistencePort.getDepartmentByName("Antioquia")).thenReturn(departmentModel);

        assertThrows(EntityAlreadyExistsException.class, () -> departmentUseCase.save(departmentModel));
        verify(departmentPersistencePort, never()).save(any());
    }
}