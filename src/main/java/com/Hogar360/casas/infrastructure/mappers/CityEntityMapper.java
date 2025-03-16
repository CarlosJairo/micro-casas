package com.Hogar360.casas.infrastructure.mappers;

import com.Hogar360.casas.domain.model.CityModel;
import com.Hogar360.casas.infrastructure.entities.CityEntity;
import com.Hogar360.casas.infrastructure.entities.DepartmentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = DepartmentEntityMapper.class)
public interface CityEntityMapper {

    @Mapping(target = "department", source = "departmentId", qualifiedByName = "mapDepartmentFromId")
    CityEntity modelToEntity(CityModel cityModel);

    @Mapping(target = "departmentId", source = "department.id")
    CityModel entityToModel(CityEntity cityEntity);

    @Named("mapDepartmentFromId")
    default DepartmentEntity mapDepartmentFromId(Long departmentId) {
        if (departmentId == null) {
            return null;
        }
        DepartmentEntity department = new DepartmentEntity();
        department.setId(departmentId);
        return department;
    }
}