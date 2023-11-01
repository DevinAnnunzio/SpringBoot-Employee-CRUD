package com.annunzio.employeecrud.rest;

import com.annunzio.employeecrud.dao.EmployeeDAO;
import com.annunzio.employeecrud.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/company")
public class EmployeeRestController {
    private EmployeeDAO employeeDAO;
    //Dirty solution - inject DAO directly
    public EmployeeRestController(EmployeeDAO empDao){
        this.employeeDAO = empDao;
    }

    //expose /employees endpoint
    @GetMapping("/employees")
    public List<Employee> findAllEmployees(){
        return employeeDAO.findAllEmployees();
    }
}
