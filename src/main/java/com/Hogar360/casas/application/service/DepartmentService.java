package com.Hogar360.casas.application.service;

import com.Hogar360.casas.application.dto.request.SaveDepartmentRequest;
import com.Hogar360.casas.application.dto.response.SaveDepartmentResponse;

public interface DepartmentService {
    SaveDepartmentResponse save(SaveDepartmentRequest saveDepartmentRequest);
}
