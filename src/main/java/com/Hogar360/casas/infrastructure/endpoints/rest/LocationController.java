package com.Hogar360.casas.infrastructure.endpoints.rest;

import com.Hogar360.casas.application.dto.response.LocationResponse;
import com.Hogar360.casas.application.dto.response.PaginationResponse;
import com.Hogar360.casas.application.service.LocationService;
import com.Hogar360.casas.commons.configurations.utils.Constants;
import com.Hogar360.casas.infrastructure.utils.constants.EndpointPaths;
import com.Hogar360.casas.infrastructure.utils.constants.SwaggerDescriptions;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EndpointPaths.LOCATION_BASE)
@RequiredArgsConstructor
@Tag(name = "Location", description = SwaggerDescriptions.LOCATION_TAG)
public class LocationController {

    private final LocationService locationService;

    @Operation(
            summary = SwaggerDescriptions.LOCATION_SEARCH_SUMMARY,
            description = SwaggerDescriptions.LOCATION_SEARCH_DESCRIPTION
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = SwaggerDescriptions.RESPONSE_200),
            @ApiResponse(responseCode = "400", description = SwaggerDescriptions.RESPONSE_400)
    })
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
