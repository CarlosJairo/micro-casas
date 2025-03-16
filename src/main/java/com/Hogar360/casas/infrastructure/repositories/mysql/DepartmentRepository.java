package com.Hogar360.casas.infrastructure.repositories.mysql;

import com.Hogar360.casas.infrastructure.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
    Optional<DepartmentEntity> findByName(String name);
}

