package com.Hogar360.casas.infrastructure.endpoints.rest;

import com.Hogar360.casas.application.dto.request.SaveDepartmentRequest;
import com.Hogar360.casas.application.dto.response.SaveDepartmentResponse;
import com.Hogar360.casas.application.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("department")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<SaveDepartmentResponse> saveDepartment(
            @RequestBody SaveDepartmentRequest saveDepartmentRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.save(saveDepartmentRequest));
    }
}
