package com.Hogar360.casas.infrastructure.adapters.persistence;

import com.Hogar360.casas.domain.model.CityModel;
import com.Hogar360.casas.domain.ports.out.CityPersistencePort;
import com.Hogar360.casas.domain.utils.pagination.Pagination;
import com.Hogar360.casas.infrastructure.entities.CityEntity;
import com.Hogar360.casas.infrastructure.mappers.CityEntityMapper;
import com.Hogar360.casas.infrastructure.repositories.mysql.CityRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CityServiceAdapter implements CityPersistencePort {
    private final CityRepository cityRepository;
    private final CityEntityMapper cityEntityMapper;

    @Override
    public CityModel  save(CityModel cityModel) {
        CityEntity cityEntity = cityEntityMapper.modelToEntity(cityModel);
        CityEntity savedEntity = cityRepository.save(cityEntity);

        return cityEntityMapper.entityToModel(savedEntity);
    }

    @Override
    public CityModel getCityByName(String cityName) {
        return cityEntityMapper.entityToModel(cityRepository.findByName(cityName).orElse(null));
    }

    @Override
    public Pagination<CityModel> searchCities(String query, int page, int size, String sortBy, String order) {
        Sort sort = Sort.by(Sort.Direction.fromString(order), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<CityEntity> cityPage = cityRepository.searchCities(query, pageable);

        List<CityModel> cityModels = cityPage.getContent()
                .stream()
                .map(cityEntityMapper::entityToModel)
                .toList();

        return new Pagination<>(
                cityModels,
                cityPage.getTotalElements(),
                cityPage.getTotalPages(),
                cityPage.getSize(),
                cityPage.getNumber()
        );
    }
}
