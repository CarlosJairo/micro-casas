package com.Hogar360.casas.infrastructure.mappers;

import com.Hogar360.casas.application.dto.response.LocationResponse;
import com.Hogar360.casas.domain.model.LocationModel;
import com.Hogar360.casas.infrastructure.entities.CategoryEntity;
import com.Hogar360.casas.infrastructure.entities.LocationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LocationEntityMapper {
    @Mapping(target = "cityId", source = "city.id")
    @Mapping(target = "cityName", source = "city.name")
    @Mapping(target = "departmentId", source = "department.id")
    @Mapping(target = "departmentName", source = "department.name")
    LocationResponse entityToResponse(LocationEntity entity);
}
