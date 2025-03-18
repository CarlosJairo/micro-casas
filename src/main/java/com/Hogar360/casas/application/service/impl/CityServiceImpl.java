package com.Hogar360.casas.application.service.impl;

import com.Hogar360.casas.application.dto.request.SaveCityRequest;
import com.Hogar360.casas.application.dto.response.CityResponse;
import com.Hogar360.casas.application.dto.response.PaginationResponse;
import com.Hogar360.casas.application.dto.response.SaveCityResponse;
import com.Hogar360.casas.application.mappers.CityDtoMapper;
import com.Hogar360.casas.application.service.CityService;
import com.Hogar360.casas.commons.configurations.utils.Constants;
import com.Hogar360.casas.commons.configurations.utils.DateTimeUtil;
import com.Hogar360.casas.domain.model.CityModel;
import com.Hogar360.casas.domain.ports.in.CityServicePort;
import com.Hogar360.casas.domain.utils.pagination.Pagination;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityServicePort cityServicePort;
    private final CityDtoMapper cityDtoMapper;

    @Override
    public SaveCityResponse save(SaveCityRequest saveCityRequest) {
        cityServicePort.save(cityDtoMapper.requestToModel(saveCityRequest));

        return new SaveCityResponse(
                Constants.SAVE_CITY_RESPONSE_MESSAGE, DateTimeUtil.getCurrentTimestamp());
    }

    @Override
    public PaginationResponse<CityResponse> searchCities(String query, Pageable pageable) {
        // Llamamos al dominio para hacer la búsqueda
        Pagination<CityModel> cityPage = cityServicePort.searchCities(
                query,
                pageable.getPageNumber(),
                pageable.getPageSize(),
                pageable.getSort().toList().get(0).getProperty(),
                pageable.getSort().toList().get(0).getDirection().name()
        );

        // Convertimos `CityModel` a `CityResponse`
        List<CityResponse> cityResponses = cityPage.getContent()
                .stream()
                .map(cityDtoMapper::modelToResponse)
                .toList();

        // Retornamos la paginación con los datos convertidos
        return new PaginationResponse<>(
                cityResponses,
                cityPage.getTotalElements(),
                cityPage.getTotalPages(),
                cityPage.getSize(),
                cityPage.getNumber()
        );
    }

}
