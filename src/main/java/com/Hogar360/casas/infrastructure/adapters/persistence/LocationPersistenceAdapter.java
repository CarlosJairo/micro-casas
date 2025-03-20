package com.Hogar360.casas.infrastructure.adapters.persistence;

import com.Hogar360.casas.application.dto.response.LocationResponse;
import com.Hogar360.casas.application.dto.response.PaginationResponse;
import com.Hogar360.casas.domain.model.LocationModel;
import com.Hogar360.casas.domain.model.LocationQueryModel;
import com.Hogar360.casas.domain.ports.out.LocationPersistencePort;
import com.Hogar360.casas.domain.utils.pagination.Pagination;
import com.Hogar360.casas.infrastructure.entities.CityEntity;
import com.Hogar360.casas.infrastructure.entities.DepartmentEntity;
import com.Hogar360.casas.infrastructure.entities.LocationEntity;
import com.Hogar360.casas.infrastructure.mappers.LocationEntityMapper;
import com.Hogar360.casas.infrastructure.repositories.mysql.LocationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class LocationPersistenceAdapter implements LocationPersistencePort {
    private final LocationRepository locationRepository;
    private final LocationEntityMapper locationEntityMapper;
    @Override
    public void save(Long cityId, Long departmentId) {
        LocationEntity locationEntity = new LocationEntity();

        CityEntity city = new CityEntity();
        city.setId(cityId);
        locationEntity.setCity(city);

        DepartmentEntity department = new DepartmentEntity();
        department.setId(departmentId);
        locationEntity.setDepartment(department);

        locationRepository.save(locationEntity);
    }

    @Override
    public Pagination<LocationQueryModel> getLocations(String query, Long departmentId, Integer page, Integer size, boolean orderAsc) {
        Sort sort = orderAsc ? Sort.by("city.name").ascending() : Sort.by("city.name").descending();
        Pageable pageable = PageRequest.of(page, size, sort);

        Page<LocationEntity> locationPage = locationRepository.searchByCityOrDepartment(query, departmentId, pageable);

        List<LocationQueryModel> locationModels = locationPage.getContent().stream()
                .map(locationEntity -> new LocationQueryModel(
                        locationEntity.getCity().getId(),
                        locationEntity.getCity().getName(),
                        locationEntity.getDepartment().getId(),
                        locationEntity.getDepartment().getName()
                )).toList();

        return new Pagination<>(
                locationModels,
                locationPage.getTotalElements(),
                locationPage.getTotalPages(),
                locationPage.getSize(),
                locationPage.getNumber()
        );
    }

}

