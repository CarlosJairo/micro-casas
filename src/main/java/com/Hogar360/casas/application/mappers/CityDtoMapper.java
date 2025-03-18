package com.Hogar360.casas.application.mappers;

import com.Hogar360.casas.application.dto.request.SaveCityRequest;
import com.Hogar360.casas.application.dto.response.CityResponse;
import com.Hogar360.casas.domain.model.CityModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CityDtoMapper {
    CityModel requestToModel(SaveCityRequest saveCityRequest);
    @Mapping(target = "department", source = "departmentId") // 🔹 Convertir ID del departamento en nombre
    CityResponse modelToResponse(CityModel cityModel);
}
