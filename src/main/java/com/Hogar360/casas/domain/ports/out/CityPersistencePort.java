package com.Hogar360.casas.domain.ports.out;

import com.Hogar360.casas.domain.model.CityModel;

public interface CityPersistencePort {
    void save(CityModel cityModel);
    CityModel getCityByName(String cityName);
}
