package com.Hogar360.casas.domain.ports.in;

import com.Hogar360.casas.domain.model.LocationModel;

public interface LocationServicePort {
    void save(Long cityId, Long departmentId );
}
