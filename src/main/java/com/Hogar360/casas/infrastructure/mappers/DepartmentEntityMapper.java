package com.Hogar360.casas.infrastructure.mappers;

import com.Hogar360.casas.domain.model.DepartmentModel;
import com.Hogar360.casas.infrastructure.entities.DepartmentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = CityEntityMapper.class)
public interface DepartmentEntityMapper {
    DepartmentEntity modelToEntity(DepartmentModel departmentModel);
    DepartmentModel entityToModel (DepartmentEntity departmentEntity);
}
