package com.Hogar360.casas.domain.usescases;

import com.Hogar360.casas.domain.exceptions.DepartmentNotExistException;
import com.Hogar360.casas.domain.model.CityModel;
import com.Hogar360.casas.domain.model.DepartmentModel;
import com.Hogar360.casas.domain.ports.in.CityServicePort;
import com.Hogar360.casas.domain.ports.out.CityPersistencePort;
import com.Hogar360.casas.domain.ports.out.DepartmentPersistencePort;
import com.Hogar360.casas.domain.utils.constants.CityDomainConstants;

public class CityUseCase implements CityServicePort {
    private final CityPersistencePort cityPersistencePort;
    private final DepartmentPersistencePort departmentPersistencePort;

    public CityUseCase(CityPersistencePort cityPersistencePort, DepartmentPersistencePort departmentPersistencePort) {
        this.cityPersistencePort = cityPersistencePort;
        this.departmentPersistencePort = departmentPersistencePort;
    }

    @Override
    public CityModel save(CityModel cityModel) {
        DepartmentModel department = departmentPersistencePort.getDepartmentById(cityModel.getDepartmentId());

        if (department == null) {
            throw new DepartmentNotExistException(CityDomainConstants.DEPARTMENT_NOT_FOUND);
        }

        return cityPersistencePort.save(cityModel);
    }
}
