package com.Hogar360.casas.infrastructure.endpoints.rest;

import com.Hogar360.casas.application.dto.request.SaveDepartmentRequest;
import com.Hogar360.casas.application.dto.response.SaveDepartmentResponse;
import com.Hogar360.casas.application.service.DepartmentService;
import com.Hogar360.casas.infrastructure.utils.constants.EndpointPaths;
import com.Hogar360.casas.infrastructure.utils.constants.SwaggerDescriptions;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EndpointPaths.DEPARTMENT_BASE)
@RequiredArgsConstructor
@Tag(name = "Department", description = SwaggerDescriptions.DEPARTMENT_TAG)
public class DepartmentController {

    private final DepartmentService departmentService;

    @Operation(
            summary = SwaggerDescriptions.DEPARTMENT_CREATE_SUMMARY,
            description = SwaggerDescriptions.DEPARTMENT_CREATE_DESCRIPTION
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = SwaggerDescriptions.RESPONSE_201),
            @ApiResponse(responseCode = "400", description = SwaggerDescriptions.RESPONSE_400),
    })
    @PostMapping
    public ResponseEntity<SaveDepartmentResponse> saveDepartment(
            @RequestBody SaveDepartmentRequest saveDepartmentRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.save(saveDepartmentRequest));
    }
}
