package com.Hogar360.casas.application.service;

import com.Hogar360.casas.application.dto.request.SaveCityRequest;
import com.Hogar360.casas.application.dto.response.SaveCityResponse;

public interface CityService {
    SaveCityResponse save(SaveCityRequest saveCityRequest);
}
