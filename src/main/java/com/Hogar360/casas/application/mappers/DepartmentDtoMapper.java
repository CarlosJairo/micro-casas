package com.Hogar360.casas.application.mappers;

import com.Hogar360.casas.application.dto.request.SaveDepartmentRequest;
import com.Hogar360.casas.domain.model.DepartmentModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DepartmentDtoMapper {
    DepartmentModel requestToModel (SaveDepartmentRequest saveDepartmentRequest);
}
