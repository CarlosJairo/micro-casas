package com.Hogar360.casas.commons.configurations.beans;

import com.Hogar360.casas.domain.ports.in.CategoryServicePort;
import com.Hogar360.casas.domain.ports.in.CityServicePort;
import com.Hogar360.casas.domain.ports.in.DepartmentServicePort;
import com.Hogar360.casas.domain.ports.in.LocationServicePort;
import com.Hogar360.casas.domain.ports.out.CategoryPersistencePort;
import com.Hogar360.casas.domain.ports.out.CityPersistencePort;
import com.Hogar360.casas.domain.ports.out.DepartmentPersistencePort;
import com.Hogar360.casas.domain.ports.out.LocationPersistencePort;
import com.Hogar360.casas.domain.usescases.CategoryUseCase;
import com.Hogar360.casas.domain.usescases.CityUseCase;
import com.Hogar360.casas.domain.usescases.DepartmentUseCase;
import com.Hogar360.casas.domain.usescases.LocationUseCase;
import com.Hogar360.casas.infrastructure.adapters.persistence.CategoryServiceAdapter;
import com.Hogar360.casas.infrastructure.adapters.persistence.CityServiceAdapter;
import com.Hogar360.casas.infrastructure.adapters.persistence.DepartmentServiceAdapter;
import com.Hogar360.casas.infrastructure.adapters.persistence.LocationPersistenceAdapter;
import com.Hogar360.casas.infrastructure.mappers.CategoryEntityMapper;
import com.Hogar360.casas.infrastructure.mappers.CityEntityMapper;
import com.Hogar360.casas.infrastructure.mappers.DepartmentEntityMapper;
import com.Hogar360.casas.infrastructure.mappers.LocationEntityMapper;
import com.Hogar360.casas.infrastructure.repositories.mysql.CategoryRepository;
import com.Hogar360.casas.infrastructure.repositories.mysql.CityRepository;
import com.Hogar360.casas.infrastructure.repositories.mysql.DepartmentRepository;
import com.Hogar360.casas.infrastructure.repositories.mysql.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final CategoryRepository categoryRepository;
    private final DepartmentRepository departmentRepository;
    private final CityRepository cityRepository;
    private final CategoryEntityMapper categoryEntityMapper;
    private final DepartmentEntityMapper departmentEntityMapper;
    private final CityEntityMapper cityEntityMapper;
    private final LocationRepository locationRepository;
    private final LocationEntityMapper locationEntityMapper;

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

    @Bean
    public CityServicePort cityServicePort() {
        return new CityUseCase(cityPersistencePort());
    }

    @Bean
    public CityPersistencePort cityPersistencePort() {
        return new CityServiceAdapter(cityRepository, cityEntityMapper);
    }

    @Bean
    public LocationServicePort locationServicePort() {
        return new LocationUseCase(locationPersistencePort());
    }

    @Bean
    public LocationPersistencePort locationPersistencePort() {
        return new LocationPersistenceAdapter(locationRepository, locationEntityMapper);
    }
}

