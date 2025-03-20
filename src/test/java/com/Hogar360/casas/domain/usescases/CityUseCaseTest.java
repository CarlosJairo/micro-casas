package com.Hogar360.casas.domain.usescases;

import com.Hogar360.casas.domain.exceptions.DepartmentNotExistException;
import com.Hogar360.casas.domain.model.CityModel;
import com.Hogar360.casas.domain.model.DepartmentModel;
import com.Hogar360.casas.domain.ports.out.CityPersistencePort;
import com.Hogar360.casas.domain.ports.out.DepartmentPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CityUseCaseTest {

    private CityPersistencePort cityPersistencePort;
    private DepartmentPersistencePort departmentPersistencePort;
    private CityUseCase cityUseCase;

    @BeforeEach
    void setUp() {
        cityPersistencePort = mock(CityPersistencePort.class);
        departmentPersistencePort = mock(DepartmentPersistencePort.class);
        cityUseCase = new CityUseCase(cityPersistencePort, departmentPersistencePort);
    }

    @Test
    void testSaveCity_Successful() {
        CityModel cityModel = new CityModel(1L, "Envigado", "Ciudad", 2L);
        DepartmentModel departmentModel = new DepartmentModel(2L, "Antioquia", "Departamento", Collections.emptyList());

        when(departmentPersistencePort.getDepartmentById(2L)).thenReturn(departmentModel);
        when(cityPersistencePort.save(cityModel)).thenReturn(cityModel);

        CityModel result = cityUseCase.save(cityModel);

        assertEquals(cityModel, result);
        verify(cityPersistencePort).save(cityModel);
    }

    @Test
    void testSaveCity_DepartmentNotFound_ThrowsException() {
        CityModel cityModel = new CityModel(1L, "Envigado", "Ciudad", 999L);
        when(departmentPersistencePort.getDepartmentById(999L)).thenReturn(null);

        assertThrows(DepartmentNotExistException.class, () -> cityUseCase.save(cityModel));
        verify(cityPersistencePort, never()).save(any());
    }
}