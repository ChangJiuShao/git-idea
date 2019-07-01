package com.wisdom56.service.impl;

import com.wisdom56.domain.Employee;
import com.wisdom56.mapper.EmpMapper;
import com.wisdom56.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpMapper<Employee> empMapper;
    @Override
    public List<Employee> findAll() {
        return empMapper.selectAll();
    }

    @Override
    public Employee findById(Employee employee) {
        return empMapper.selectByPrimaryKey(employee);
    }

    @Override
    public void save(Employee employee) {
  empMapper.insert(employee);
    }

    @Override
    public void update(Employee employee) {
        empMapper.updateByPrimaryKey(employee);
    }

    @Override
    public void delete(Employee employee) {

        empMapper.deleteByPrimaryKey(employee);

    }
}
