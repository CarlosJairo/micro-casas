package com.Hogar360.casas.domain.usescases;

import com.Hogar360.casas.domain.model.CityModel;
import com.Hogar360.casas.domain.ports.in.CityServicePort;
import com.Hogar360.casas.domain.ports.out.CityPersistencePort;

public class CityUseCase implements CityServicePort {
    private final CityPersistencePort cityPersistencePort;

    public CityUseCase(CityPersistencePort cityPersistencePort) {
        this.cityPersistencePort = cityPersistencePort;
    }

    @Override
    public CityModel  save(CityModel cityModel) {
        return  cityPersistencePort.save(cityModel);
    }
}
