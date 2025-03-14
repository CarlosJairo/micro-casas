package com.Hogar360.casas.commons.configurations.beans;

import com.Hogar360.casas.category.domain.ports.out.CategoryPersistencePort;
import com.Hogar360.casas.category.domain.usescases.CategoryUseCase;
import com.Hogar360.casas.category.infrastructure.adapters.persistence.CategoryServiceAdapter;
import com.Hogar360.casas.category.infrastructure.mappers.CategoryEntityMapper;
import com.Hogar360.casas.category.infrastructure.repositories.mysql.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final CategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    @Bean
    public com.Hogar360.casas.category.domain.ports.in.CategoryServicePort categoryServicePort() {
        return new CategoryUseCase(categoryPersistencePort());
    }

    @Bean
    public CategoryPersistencePort categoryPersistencePort() {
        return new CategoryServiceAdapter(categoryRepository, categoryEntityMapper);
    }
}

