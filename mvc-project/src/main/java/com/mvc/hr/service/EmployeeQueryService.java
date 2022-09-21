package com.mvc.hr.service;

import com.mvc.hr.domian.EmployRepository;
import com.mvc.hr.service.dto.EmployeeCreatedResponse;

public class EmployeeQueryService {
    private final EmployRepository employRepository;

    public EmployeeQueryService(EmployRepository employRepository) {
        this.employRepository = employRepository;
    }

    public EmployeeCreatedResponse findByNo(String no) {
        return EmployeeCreatedResponse.of(employRepository.findByNo(no));
    }
}
