package com.annunzio.employeecrud.service;

import com.annunzio.employeecrud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAllEmployees();
}
