package com.Hogar360.casas.domain.ports.out;

import com.Hogar360.casas.domain.model.LocationModel;

public interface LocationPersistencePort {
    void save(Long cityId, Long departmentId);
}
