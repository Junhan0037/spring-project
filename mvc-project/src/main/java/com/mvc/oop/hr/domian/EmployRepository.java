package com.mvc.oop.hr.domian;

public interface EmployRepository {
    void createEmployee(Employee employee);

    Employee findByNo(String no);
}
