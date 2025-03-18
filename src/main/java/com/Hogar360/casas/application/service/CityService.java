package com.Hogar360.casas.application.service;

import com.Hogar360.casas.application.dto.request.SaveCityRequest;
import com.Hogar360.casas.application.dto.response.CityResponse;
import com.Hogar360.casas.application.dto.response.PaginationResponse;
import com.Hogar360.casas.application.dto.response.SaveCityResponse;
import org.springframework.data.domain.Pageable;

public interface CityService {
    SaveCityResponse save(SaveCityRequest saveCityRequest);
    PaginationResponse<CityResponse> searchCities(String query, Pageable pageable);
}
