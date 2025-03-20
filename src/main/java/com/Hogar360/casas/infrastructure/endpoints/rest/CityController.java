package com.Hogar360.casas.infrastructure.endpoints.rest;

import com.Hogar360.casas.application.dto.request.SaveCityRequest;
import com.Hogar360.casas.application.dto.response.SaveCityResponse;
import com.Hogar360.casas.application.service.CityService;
import com.Hogar360.casas.infrastructure.utils.constants.EndpointPaths;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(EndpointPaths.CITY_BASE)
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;

    @PostMapping
    public ResponseEntity<SaveCityResponse> save(@RequestBody SaveCityRequest saveCityRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cityService.save(saveCityRequest));
    }
}
