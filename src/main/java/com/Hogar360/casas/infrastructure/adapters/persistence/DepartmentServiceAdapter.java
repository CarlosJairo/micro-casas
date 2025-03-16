package com.Hogar360.casas.infrastructure.adapters.persistence;

import com.Hogar360.casas.domain.model.DepartmentModel;
import com.Hogar360.casas.domain.ports.out.DepartmentPersistencePort;
import com.Hogar360.casas.infrastructure.mappers.DepartmentEntityMapper;
import com.Hogar360.casas.infrastructure.repositories.mysql.DepartmentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class DepartmentServiceAdapter implements DepartmentPersistencePort {
    private final DepartmentRepository departmentRepository;
    private final DepartmentEntityMapper departmentEntityMapper;

    @Override
    public void save(DepartmentModel departmentModel) {
        departmentRepository.save(departmentEntityMapper.modelToEntity(departmentModel));
    }

    @Override
    public DepartmentModel getDepartmentByName(String departmentName) {
        return departmentEntityMapper.entityToModel(departmentRepository.findByName(departmentName).orElse(null));
    }
}
