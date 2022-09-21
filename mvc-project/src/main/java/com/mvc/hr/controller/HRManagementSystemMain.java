package com.mvc.hr.controller;

import com.mvc.hr.infra.InMemoryEmployRepository;
import com.mvc.hr.service.EmployeeCommandService;
import com.mvc.hr.service.EmployeeQueryService;
import com.mvc.hr.service.dto.EmployeeCreateRequest;
import com.mvc.hr.service.dto.EmployeeCreatedResponse;
import com.mvc.hr.ui.console.ConsoleInputUI;
import com.mvc.hr.ui.console.ConsoleOutputUI;

public class HRManagementSystemMain {
    private static final InMemoryEmployRepository repository = new InMemoryEmployRepository();
    private static final EmployeeCommandService commandService = new EmployeeCommandService(repository);
    private static final EmployeeQueryService queryService = new EmployeeQueryService(repository);

    public static void main(String[] args) {
        String name = ConsoleInputUI.enterName();
        String no = ConsoleInputUI.enterNo();
        String ssn = ConsoleInputUI.socialSecurityNumber();

        commandService.add(new EmployeeCreateRequest(no, name, ssn));
        EmployeeCreatedResponse response = queryService.findByNo(no);

        ConsoleOutputUI.printResult(response);
    }
}
