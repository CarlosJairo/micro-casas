package com.Hogar360.casas.domain.ports.in;

import com.Hogar360.casas.domain.model.CityModel;

public interface CityServicePort {
    CityModel save(CityModel cityModel);
}
