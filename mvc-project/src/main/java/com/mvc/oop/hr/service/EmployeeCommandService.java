package com.mvc.oop.hr.service;

import com.mvc.oop.hr.domian.EmployRepository;
import com.mvc.oop.hr.service.dto.EmployeeCreateRequest;

public class EmployeeCommandService {
    private final EmployRepository employRepository;

    public EmployeeCommandService(EmployRepository employRepository) {
        this.employRepository = employRepository;
    }

    public void add(EmployeeCreateRequest createRequest) {
        employRepository.createEmployee(createRequest.toDomain());
    }
}
