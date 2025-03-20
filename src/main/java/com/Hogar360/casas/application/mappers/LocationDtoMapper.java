package com.Hogar360.casas.application.mappers;

import com.Hogar360.casas.application.dto.response.LocationResponse;
import com.Hogar360.casas.domain.model.LocationModel;
import com.Hogar360.casas.domain.model.LocationQueryModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LocationDtoMapper {
    LocationResponse queryModelToResponse(LocationQueryModel model);

    List<LocationResponse> modelListToResponseList(List<LocationQueryModel> models);
}
