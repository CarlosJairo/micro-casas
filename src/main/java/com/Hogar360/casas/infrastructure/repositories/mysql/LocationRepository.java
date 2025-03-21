package com.Hogar360.casas.infrastructure.repositories.mysql;

import com.Hogar360.casas.infrastructure.entities.LocationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LocationRepository extends JpaRepository<LocationEntity, Long> {
    @Query("""
    SELECT l FROM LocationEntity l
    JOIN FETCH l.city c
    JOIN FETCH l.department d
    WHERE (:query IS NULL OR LOWER(c.name) LIKE LOWER(CONCAT('%', :query, '%')) OR LOWER(d.name) LIKE LOWER(CONCAT('%', :query, '%')))
      AND (:departmentId IS NULL OR d.id = :departmentId)
""")
    Page<LocationEntity> searchByCityOrDepartment(@Param("query") String query, @Param("departmentId") Long departmentId, Pageable pageable);}
