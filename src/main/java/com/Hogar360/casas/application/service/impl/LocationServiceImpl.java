package com.Hogar360.casas.application.service.impl;

import com.Hogar360.casas.application.dto.response.LocationResponse;
import com.Hogar360.casas.application.dto.response.PaginationResponse;
import com.Hogar360.casas.application.mappers.LocationDtoMapper;
import com.Hogar360.casas.application.service.LocationService;
import com.Hogar360.casas.domain.model.LocationQueryModel;
import com.Hogar360.casas.domain.ports.in.LocationServicePort;
import com.Hogar360.casas.domain.utils.pagination.Pagination;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {
    private final LocationServicePort locationServicePort;
    private final LocationDtoMapper locationDtoMapper;

    @Override
    public PaginationResponse<LocationResponse> getLocations(String query, Long departmentId,  Integer page, Integer size, boolean orderAsc) {
        Pagination<LocationQueryModel> paginationModel =  locationServicePort.getLocations(query, departmentId, page, size, orderAsc);

        return new PaginationResponse<>(
                locationDtoMapper.modelListToResponseList(paginationModel.getContent()), // Ahora acepta LocationQueryModel
                paginationModel.getTotalElements(),
                paginationModel.getTotalPages(),
                paginationModel.getSize(),
                paginationModel.getNumber()
        );
    }
}
