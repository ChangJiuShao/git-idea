package com.springboot.service.impl;

import com.springboot.domain.Employee;
import com.springboot.mapper.EmpMapper;
import com.springboot.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpMapper mapper;

    @Override
    public List<Employee> findAll() {
        return mapper.selectAll();
    }

    @Override
    public void save(Employee employee) {
    mapper.insert(employee);
    }

    @Override
    public void update(Employee employee) {
    mapper.updateByPrimaryKey(employee);
    }

    @Override
    public void delete(Integer id) {
    mapper.deleteByPrimaryKey(id);
    }
}
