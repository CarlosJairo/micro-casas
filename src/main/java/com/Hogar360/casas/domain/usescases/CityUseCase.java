package com.Hogar360.casas.domain.usescases;

import com.Hogar360.casas.domain.exceptions.EntityAlreadyExistsException;
import com.Hogar360.casas.domain.model.CityModel;
import com.Hogar360.casas.domain.ports.in.CityServicePort;
import com.Hogar360.casas.domain.ports.out.CityPersistencePort;
import com.Hogar360.casas.domain.utils.pagination.Pagination;
import com.Hogar360.casas.domain.utils.constants.DomainConstants;

public class CityUseCase implements CityServicePort {
    private final CityPersistencePort cityPersistencePort;

    public CityUseCase(CityPersistencePort cityPersistencePort) {
        this.cityPersistencePort = cityPersistencePort;
    }

    @Override
    public CityModel  save(CityModel cityModel) {
        return  cityPersistencePort.save(cityModel);
    }

    @Override
    public Pagination<CityModel> searchCities(String query, int page, int size, String sortBy, String order) {
        return cityPersistencePort.searchCities(query, page, size, sortBy, order);
    }
}
