package com.Hogar360.casas.domain.usescases;

import com.Hogar360.casas.domain.model.LocationQueryModel;
import com.Hogar360.casas.domain.ports.out.LocationPersistencePort;
import com.Hogar360.casas.domain.utils.pagination.Pagination;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class LocationUseCaseTest {

    private LocationPersistencePort locationPersistencePort;
    private LocationUseCase locationUseCase;

    @BeforeEach
    void setUp() {
        locationPersistencePort = mock(LocationPersistencePort.class);
        locationUseCase = new LocationUseCase(locationPersistencePort);
    }

    @Test
    void testSaveLocation_Successful() {
        // Arrange
        Long cityId = 1L;
        Long departmentId = 2L;

        // Act
        locationUseCase.save(cityId, departmentId);

        // Assert
        verify(locationPersistencePort).save(cityId, departmentId);
    }

    @Test
    void testGetLocations_Successful() {
        // Arrange
        String query = "Antioquia";
        Long departmentId = 1L;
        Integer page = 0;
        Integer size = 10;
        boolean orderAsc = true;
        Pagination<LocationQueryModel> pagination = new Pagination<>(null, 0, 0, 10, 0);

        when(locationPersistencePort.getLocations(query, departmentId, page, size, orderAsc))
                .thenReturn(pagination);

        // Act
        Pagination<LocationQueryModel> result = locationUseCase.getLocations(query, departmentId, page, size, orderAsc);

        // Assert
        verify(locationPersistencePort).getLocations(query, departmentId, page, size, orderAsc);
        assertEquals(pagination, result);
    }
}