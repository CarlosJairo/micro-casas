package com.Hogar360.casas.domain.usescases;

import com.Hogar360.casas.domain.exceptions.EntityAlreadyExistsException;
import com.Hogar360.casas.domain.model.DepartmentModel;
import com.Hogar360.casas.domain.ports.in.DepartmentServicePort;
import com.Hogar360.casas.domain.ports.out.DepartmentPersistencePort;
import com.Hogar360.casas.domain.utils.constants.DepartmentDomainConstants;

public class DepartmentUseCase implements DepartmentServicePort {
    private final DepartmentPersistencePort departmentPersistencePort;

    public DepartmentUseCase(DepartmentPersistencePort departmentPersistencePort) {
        this.departmentPersistencePort = departmentPersistencePort;
    }

    @Override
    public void save(DepartmentModel departmentModel) {
        DepartmentModel department = departmentPersistencePort.getDepartmentByName(departmentModel.getName());

        if (department != null) {
            throw new EntityAlreadyExistsException(DepartmentDomainConstants.DEPARTMENT_NAME_ENTITY);
        }

        departmentPersistencePort.save(departmentModel);
    }


}

