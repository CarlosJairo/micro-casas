package com.Hogar360.casas.application.service.impl;

import com.Hogar360.casas.application.dto.request.SaveDepartmentRequest;
import com.Hogar360.casas.application.dto.response.SaveDepartmentResponse;
import com.Hogar360.casas.application.mappers.DepartmentDtoMapper;
import com.Hogar360.casas.application.service.DepartmentService;
import com.Hogar360.casas.commons.configurations.utils.Constants;
import com.Hogar360.casas.commons.configurations.utils.DateTimeUtil;
import com.Hogar360.casas.domain.ports.in.DepartmentServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentServicePort departmentServicePort;
    private final DepartmentDtoMapper departmentDtoMapper;

    @Override
    public SaveDepartmentResponse save(SaveDepartmentRequest saveDepartmentRequest) {
        departmentServicePort.save(departmentDtoMapper.requestToModel(saveDepartmentRequest));

        return new SaveDepartmentResponse(Constants.SAVE_DEPARTMENT_RESPONSE_MESSAGE,
                DateTimeUtil.getCurrentTimestamp());
    }
}
