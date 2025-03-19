package com.Hogar360.casas.domain.ports.out;

import com.Hogar360.casas.domain.model.CityModel;
import com.Hogar360.casas.domain.utils.pagination.Pagination;

public interface CityPersistencePort {
    CityModel  save(CityModel cityModel);
    CityModel getCityByName(String cityName);
    Pagination<CityModel> searchCities(String query, int page, int size, String sortBy, String order);
}
