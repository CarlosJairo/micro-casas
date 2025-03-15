package com.Hogar360.casas.infrastructure.repositories.mysql;

import com.Hogar360.casas.infrastructure.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    Optional<CategoryEntity> findByName(String name);
}
