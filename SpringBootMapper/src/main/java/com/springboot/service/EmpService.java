package com.springboot.service;

import com.springboot.domain.Employee;
import org.hibernate.validator.constraints.URL;

import java.util.List;

public interface EmpService {

    List<Employee> findAll();

    void  save(Employee employee);

    void  update(Employee employee);

    void  delete(Integer id);


}
