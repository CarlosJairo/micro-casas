package com.Hogar360.casas.domain.usescases;

import com.Hogar360.casas.domain.model.LocationModel;
import com.Hogar360.casas.domain.ports.in.LocationServicePort;
import com.Hogar360.casas.domain.ports.out.LocationPersistencePort;


public class LocationUseCase implements LocationServicePort {
    private final LocationPersistencePort locationPersistencePort;

    public LocationUseCase(LocationPersistencePort locationPersistencePort) {
        this.locationPersistencePort = locationPersistencePort;
    }

    @Override
    public void save(Long cityId, Long departmentId) {
        locationPersistencePort.save(cityId, departmentId);
    }
}
