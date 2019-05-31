package com.ssm.service;

import com.ssm.domain.Employee;

import java.util.List;

public interface EmpService {

    List<Employee> selectAll();

    void insertEmp(Employee employee);

    boolean checkUser(String ename);
}
