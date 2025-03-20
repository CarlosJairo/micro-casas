package com.Hogar360.casas.infrastructure.endpoints.rest;

import com.Hogar360.casas.application.dto.request.SaveCityRequest;
import com.Hogar360.casas.application.dto.response.SaveCityResponse;
import com.Hogar360.casas.application.service.CityService;
import com.Hogar360.casas.infrastructure.utils.constants.EndpointPaths;
import com.Hogar360.casas.infrastructure.utils.constants.SwaggerDescriptions;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(EndpointPaths.CITY_BASE)
@RequiredArgsConstructor
@Tag(name = "City", description = SwaggerDescriptions.CITY_TAG)
public class CityController {

    private final CityService cityService;

    @Operation(
            summary = SwaggerDescriptions.CITY_CREATE_SUMMARY,
            description = SwaggerDescriptions.CITY_CREATE_DESCRIPTION
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = SwaggerDescriptions.RESPONSE_201),
            @ApiResponse(responseCode = "400", description = SwaggerDescriptions.RESPONSE_400),
    })
    @PostMapping
    public ResponseEntity<SaveCityResponse> save(@RequestBody SaveCityRequest saveCityRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cityService.save(saveCityRequest));
    }
}
