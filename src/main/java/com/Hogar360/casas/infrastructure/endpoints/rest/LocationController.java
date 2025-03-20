package com.Hogar360.casas.infrastructure.endpoints.rest;

import com.Hogar360.casas.application.dto.response.LocationResponse;
import com.Hogar360.casas.application.dto.response.PaginationResponse;
import com.Hogar360.casas.application.service.LocationService;
import com.Hogar360.casas.commons.configurations.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/locations")
@RequiredArgsConstructor
public class LocationController {
    private final LocationService locationService;

    @GetMapping
    public ResponseEntity<PaginationResponse<LocationResponse>> getLocations(
            @RequestParam(defaultValue = Constants.DEFAULT_PAGEABLE_QUERY) String query,
            @RequestParam(defaultValue = Constants.DEFAULT_PAGEABLE_PAGE) Integer page,
            @RequestParam(defaultValue = Constants.DEFAULT_PAGEABLE_SIZE) Integer size,
            @RequestParam(defaultValue = Constants.DEFAULT_PAGEABLE_ORDER_ASC) boolean orderAsc
    ) {
        return ResponseEntity.ok(locationService.getLocations(query, page, size, orderAsc));
    }
}
