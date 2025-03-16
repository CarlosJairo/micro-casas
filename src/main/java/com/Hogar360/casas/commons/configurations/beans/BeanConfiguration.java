package com.Hogar360.casas.commons.configurations.beans;

import com.Hogar360.casas.domain.ports.in.CategoryServicePort;
import com.Hogar360.casas.domain.ports.in.DepartmentServicePort;
import com.Hogar360.casas.domain.ports.out.CategoryPersistencePort;
import com.Hogar360.casas.domain.ports.out.DepartmentPersistencePort;
import com.Hogar360.casas.domain.usescases.CategoryUseCase;
import com.Hogar360.casas.domain.usescases.DepartmentUseCase;
import com.Hogar360.casas.infrastructure.adapters.persistence.CategoryServiceAdapter;
import com.Hogar360.casas.infrastructure.adapters.persistence.DepartmentServiceAdapter;
import com.Hogar360.casas.infrastructure.mappers.CategoryEntityMapper;
import com.Hogar360.casas.infrastructure.mappers.DepartmentEntityMapper;
import com.Hogar360.casas.infrastructure.repositories.mysql.CategoryRepository;
import com.Hogar360.casas.infrastructure.repositories.mysql.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final CategoryRepository categoryRepository;
    private final DepartmentRepository departmentRepository;
    private final CategoryEntityMapper categoryEntityMapper;
    private final DepartmentEntityMapper departmentEntityMapper;

    @Bean
    public CategoryServicePort categoryServicePort() {
        return new CategoryUseCase(categoryPersistencePort());
    }

    @Bean
    public CategoryPersistencePort categoryPersistencePort() {
        return new CategoryServiceAdapter(categoryRepository, categoryEntityMapper);
    }

    @Bean
    public DepartmentServicePort departmentServicePort() {
        return new DepartmentUseCase(departmentPersistencePort());
    }

    @Bean
    public DepartmentPersistencePort departmentPersistencePort() {
        return new DepartmentServiceAdapter(departmentRepository, departmentEntityMapper);
    }
}

