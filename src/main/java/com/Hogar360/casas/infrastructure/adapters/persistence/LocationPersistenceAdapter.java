package com.Hogar360.casas.infrastructure.adapters.persistence;

import com.Hogar360.casas.domain.ports.out.LocationPersistencePort;
import com.Hogar360.casas.infrastructure.entities.LocationEntity;
import com.Hogar360.casas.infrastructure.repositories.mysql.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationPersistenceAdapter implements LocationPersistencePort {
    private final LocationRepository locationRepository;

    @Override
    public void save(Long cityId, Long departmentId) {
        LocationEntity locationEntity = new LocationEntity();
        locationEntity.setCityId(cityId);
        locationEntity.setDepartmentId(departmentId);
        locationRepository.save(locationEntity);
    }
}

