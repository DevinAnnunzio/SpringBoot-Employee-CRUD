package com.annunzio.employeecrud.dao;

import com.annunzio.employeecrud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAllEmployees();

    Employee findById(int empId);

    Employee save(Employee theEmp);

    void deleteEmployeeById(int empId);
}
