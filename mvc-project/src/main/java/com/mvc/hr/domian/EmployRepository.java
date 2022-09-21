package com.mvc.hr.domian;

public interface EmployRepository {
    void createEmployee(Employee employee);

    Employee findByNo(String no);
}
