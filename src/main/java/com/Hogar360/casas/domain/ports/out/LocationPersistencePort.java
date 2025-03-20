package com.Hogar360.casas.domain.ports.out;

import com.Hogar360.casas.domain.model.LocationModel;
import com.Hogar360.casas.domain.model.LocationQueryModel;
import com.Hogar360.casas.domain.utils.pagination.Pagination;

public interface LocationPersistencePort {
    void save(Long cityId, Long departmentId);
    Pagination<LocationQueryModel> getLocations(String query, Integer page, Integer size, boolean orderAsc);
}
