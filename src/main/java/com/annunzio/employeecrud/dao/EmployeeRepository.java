package com.annunzio.employeecrud.dao;

import com.annunzio.employeecrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="workers")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //No need for implementation class with Spring Data JPA

}
