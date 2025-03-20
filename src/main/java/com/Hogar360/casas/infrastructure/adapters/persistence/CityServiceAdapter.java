package com.Hogar360.casas.infrastructure.adapters.persistence;

import com.Hogar360.casas.domain.model.CityModel;
import com.Hogar360.casas.domain.ports.out.CityPersistencePort;
import com.Hogar360.casas.infrastructure.entities.CityEntity;
import com.Hogar360.casas.infrastructure.mappers.CityEntityMapper;
import com.Hogar360.casas.infrastructure.repositories.mysql.CityRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
