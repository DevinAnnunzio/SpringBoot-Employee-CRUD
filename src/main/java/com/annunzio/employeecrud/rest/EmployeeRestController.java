package com.annunzio.employeecrud.rest;

import com.annunzio.employeecrud.dao.EmployeeDAO;
import com.annunzio.employeecrud.entity.Employee;
import com.annunzio.employeecrud.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/company")
public class EmployeeRestController {

//    private EmployeeDAO employeeDAO;
    //Dirty solution - inject DAO directly
    //Refactor to use service
    EmployeeService employeeService;
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    //expose /employees endpoint
    @GetMapping("/employees")
    public List<Employee> findAllEmployees(){
        return employeeService.findAllEmployees();
    }
}
