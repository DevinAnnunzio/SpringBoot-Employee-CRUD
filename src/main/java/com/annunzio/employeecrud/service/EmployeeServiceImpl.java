package com.annunzio.employeecrud.service;

import com.annunzio.employeecrud.dao.EmployeeDAO;
import com.annunzio.employeecrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeDAO employeeDAO;
    @Autowired
    public EmployeeServiceImpl(EmployeeDAO empDAO){
        this.employeeDAO = empDAO;
    }
    @Override
    public List<Employee> findAllEmployees() {
        return employeeDAO.findAllEmployees();
    }
}
