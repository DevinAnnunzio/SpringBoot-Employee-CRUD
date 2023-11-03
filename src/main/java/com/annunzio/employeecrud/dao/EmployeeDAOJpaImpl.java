package com.annunzio.employeecrud.dao;

import com.annunzio.employeecrud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    //Define field for Entity manager
    private EntityManager entityManager;
    //Set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager em){
        this.entityManager = em;
    }

    public List<Employee> findAllEmployees() {
        //Create query
        TypedQuery<Employee> getEmpQuery = entityManager.createQuery("from Employee", Employee.class);
        //exec and get results
        List<Employee> allEmp = getEmpQuery.getResultList();
        //return list
        return allEmp;
    }

    @Override
    public Employee findById(int empId) {
        //get employee
        Employee foundEmployee = entityManager.find(Employee.class, empId);
        //return employee
        return foundEmployee;
    }

    @Override
    public Employee save(Employee theEmp) {
        //Save or update if emp id == 0.  If 0 then it saves/inserts otherwise updates
        Employee theEmployee = entityManager.merge(theEmp);
        return theEmployee;
    }

    @Override
    public void deleteEmployeeById(int empId) {
        Employee theEmployee = entityManager.find(Employee.class, empId);
        entityManager.remove(theEmployee);
    }


}
