package com.Hogar360.casas.domain.ports.out;

import com.Hogar360.casas.domain.model.CityModel;

public interface CityPersistencePort {
    CityModel  save(CityModel cityModel);
}
