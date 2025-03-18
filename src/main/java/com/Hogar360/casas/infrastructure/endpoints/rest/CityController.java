package com.Hogar360.casas.infrastructure.endpoints.rest;

import com.Hogar360.casas.application.dto.request.SaveCityRequest;
import com.Hogar360.casas.application.dto.response.CityResponse;
import com.Hogar360.casas.application.dto.response.PaginationResponse;
import com.Hogar360.casas.application.dto.response.SaveCityResponse;
import com.Hogar360.casas.application.service.CityService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("city")
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;

    @PostMapping
    public ResponseEntity<SaveCityResponse> save(@RequestBody SaveCityRequest saveCityRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(cityService.save(saveCityRequest));
    };

    @GetMapping("/buscar")
    @Operation(summary = "Buscar ciudades y departamentos", description = "Busca ciudades o departamentos por texto ingresado, paginado y ordenado.")
    public ResponseEntity<PaginationResponse<CityResponse>> searchCities(
            @RequestParam String query,
            Pageable pageable) {
        return ResponseEntity.ok(cityService.searchCities(query, pageable));
    }
}
