package com.wisdom56.service;

import com.wisdom56.domain.Employee;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

public interface EmpService {

    List<Employee> findAll();

    Employee findById(Employee employee);

    void save(Employee employee);

    void update(Employee employee);

    void  delete(Employee employee);

}
