package com.Hogar360.casas.domain.ports.in;

import com.Hogar360.casas.domain.model.CityModel;
import com.Hogar360.casas.domain.utils.Pagination;

import java.util.List;

public interface CityServicePort {
    void save(CityModel cityModel);
    Pagination<CityModel> searchCities(String query, int page, int size, String sortBy, String order);
}
