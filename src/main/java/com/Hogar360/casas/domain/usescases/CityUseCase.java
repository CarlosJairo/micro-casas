package com.Hogar360.casas.domain.usescases;

import com.Hogar360.casas.domain.exceptions.EntityAlreadyExistsException;
import com.Hogar360.casas.domain.model.CityModel;
import com.Hogar360.casas.domain.ports.in.CityServicePort;
import com.Hogar360.casas.domain.ports.out.CityPersistencePort;
import com.Hogar360.casas.domain.utils.Pagination;
import com.Hogar360.casas.domain.utils.constants.DomainConstants;

import java.util.List;

public class CityUseCase implements CityServicePort {
    private final CityPersistencePort cityPersistencePort;

    public CityUseCase(CityPersistencePort cityPersistencePort) {
        this.cityPersistencePort = cityPersistencePort;
    }

    @Override
    public void save(CityModel cityModel) {
        CityModel city = cityPersistencePort.getCityByName(cityModel.getName());

        if (city != null) {
            throw new EntityAlreadyExistsException(DomainConstants.CITY_NAME_ENTITY);
        }

        cityPersistencePort.save(cityModel);
    }

    @Override
    public Pagination<CityModel> searchCities(String query, int page, int size, String sortBy, String order) {
        return cityPersistencePort.searchCities(query, page, size, sortBy, order);
    }
}
