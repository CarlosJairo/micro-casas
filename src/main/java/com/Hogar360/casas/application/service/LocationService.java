package com.Hogar360.casas.application.service;

import com.Hogar360.casas.application.dto.response.LocationResponse;
import com.Hogar360.casas.application.dto.response.PaginationResponse;

public interface LocationService {
    PaginationResponse<LocationResponse> getLocations(String query,Long departmentId, Integer page, Integer size, boolean orderAsc);
}
