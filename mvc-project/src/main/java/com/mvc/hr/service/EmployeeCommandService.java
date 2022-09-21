package com.mvc.hr.service;

import com.mvc.hr.domian.EmployRepository;
import com.mvc.hr.service.dto.EmployeeCreateRequest;

public class EmployeeCommandService {
    private final EmployRepository employRepository;

    public EmployeeCommandService(EmployRepository employRepository) {
        this.employRepository = employRepository;
    }

    public void add(EmployeeCreateRequest createRequest) {
        employRepository.createEmployee(createRequest.toDomain());
    }
}
