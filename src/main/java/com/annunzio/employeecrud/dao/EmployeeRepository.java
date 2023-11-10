package com.annunzio.employeecrud.dao;

import com.annunzio.employeecrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //No need for implementation class with Spring Data JPA

}
