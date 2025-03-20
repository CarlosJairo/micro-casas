package com.Hogar360.casas.application.service.impl;

import com.Hogar360.casas.application.dto.request.SaveCityRequest;
import com.Hogar360.casas.application.dto.response.SaveCityResponse;
import com.Hogar360.casas.application.mappers.CityDtoMapper;
import com.Hogar360.casas.application.service.CityService;
import com.Hogar360.casas.commons.configurations.utils.Constants;
import com.Hogar360.casas.commons.configurations.utils.DateTimeUtil;
import com.Hogar360.casas.domain.model.CityModel;
import com.Hogar360.casas.domain.ports.in.CityServicePort;
import com.Hogar360.casas.domain.ports.in.LocationServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityServicePort cityServicePort;
    private final CityDtoMapper cityDtoMapper;
    private final LocationServicePort locationServicePort;

    @Override
    public SaveCityResponse save(SaveCityRequest saveCityRequest) {
        CityModel cityModel = cityDtoMapper.requestToModel(saveCityRequest);

        CityModel city = cityServicePort.save(cityModel);

        locationServicePort.save(city.getId(), saveCityRequest.departmentId());

        return new SaveCityResponse(
                Constants.SAVE_CITY_RESPONSE_MESSAGE, DateTimeUtil.getCurrentTimestamp());
    }
}
