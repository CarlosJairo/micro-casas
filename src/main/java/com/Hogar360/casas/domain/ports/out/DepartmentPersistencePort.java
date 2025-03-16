package com.Hogar360.casas.domain.ports.out;

import com.Hogar360.casas.domain.model.DepartmentModel;

public interface DepartmentPersistencePort {
    void save (DepartmentModel departmentModel);
    DepartmentModel getDepartmentByName(String departmentName);
}
