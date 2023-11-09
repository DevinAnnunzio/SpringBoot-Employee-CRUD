package com.annunzio.employeecrud.rest;

import com.annunzio.employeecrud.dao.EmployeeDAO;
import com.annunzio.employeecrud.entity.Employee;
import com.annunzio.employeecrud.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

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

    //Path variable mapping must be the same
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);

        if(theEmployee == null){
            throw new RuntimeException("Employee with id: " + employeeId + " not found");
        }
        return theEmployee;
    }

    //Employee data comes in request body as json so need to use @RequestBody
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        //Just in case they pass an ID in json we manually set to 0 so it will save new item(insert)
        theEmployee.setId(0);
        Employee freshEmployee = employeeService.save(theEmployee);
        //return fresh because it contains updated id in case of update
        return freshEmployee;
    }

    //Update an employee using PUT
    @PutMapping("/employees}")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee updatedEmp = employeeService.save(theEmployee);
        return updatedEmp;
    }



}
