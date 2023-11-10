package com.annunzio.employeecrud.service;

import com.annunzio.employeecrud.dao.EmployeeDAO;
import com.annunzio.employeecrud.dao.EmployeeRepository;
import com.annunzio.employeecrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){
        employeeRepository = theEmployeeRepository;
    }
    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int empId) {
        Optional<Employee> search = employeeRepository.findById(empId);
        Employee possibleEmp = null;

        if(search.isPresent()){
            possibleEmp = search.get();
            return possibleEmp;
        } else {
            throw new RuntimeException("Could not find the employee requested with an id of {" + empId + "}.");
        }
    }

    //JPA provide @Transactional
//    @Transactional
    @Override
    public Employee save(Employee theEmp) {
        return employeeRepository.save(theEmp);
    }

//    @Transactional
    @Override
    public void deleteEmployeeById(int empId) {
        employeeRepository.deleteById(empId);
    }
}
