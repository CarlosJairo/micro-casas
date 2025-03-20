package com.Hogar360.casas.domain.usescases;

import com.Hogar360.casas.domain.model.LocationModel;
import com.Hogar360.casas.domain.model.LocationQueryModel;
import com.Hogar360.casas.domain.ports.in.LocationServicePort;
import com.Hogar360.casas.domain.ports.out.LocationPersistencePort;
import com.Hogar360.casas.domain.utils.pagination.Pagination;


public class LocationUseCase implements LocationServicePort {
    private final LocationPersistencePort locationPersistencePort;

    public LocationUseCase(LocationPersistencePort locationPersistencePort) {
        this.locationPersistencePort = locationPersistencePort;
    }

    @Override
    public void save(Long cityId, Long departmentId) {
        locationPersistencePort.save(cityId, departmentId);
    }

    @Override
    public Pagination<LocationQueryModel> getLocations(String query, Integer page, Integer size, boolean orderAsc) {
        return locationPersistencePort.getLocations(query, page, size, orderAsc);
    }
}
