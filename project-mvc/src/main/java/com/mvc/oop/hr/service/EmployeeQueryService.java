package com.mvc.oop.hr.service;

import com.mvc.oop.hr.domian.EmployRepository;
import com.mvc.oop.hr.service.dto.EmployeeCreatedResponse;

public class EmployeeQueryService {
    private final EmployRepository employRepository;

    public EmployeeQueryService(EmployRepository employRepository) {
        this.employRepository = employRepository;
    }

    public EmployeeCreatedResponse findByNo(String no) {
        return EmployeeCreatedResponse.of(employRepository.findByNo(no));
    }
}
