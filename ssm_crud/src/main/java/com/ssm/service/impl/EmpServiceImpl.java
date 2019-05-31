package com.ssm.service.impl;

import com.ssm.dao.EmployeeMapper;
import com.ssm.domain.Employee;
import com.ssm.domain.EmployeeExample;
import com.ssm.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
     @Autowired
    EmployeeMapper mapper;
    @Override
    public List<Employee> selectAll() {
        return mapper.selectByExampleWithDept(null);
    }

    @Override
    public void insertEmp(Employee employee) {
        mapper.insertSelective(employee);
    }

    @Override
    public boolean checkUser(String ename) {

        EmployeeExample employeeExample = new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andEnameEqualTo(ename);
        long count = mapper.countByExample(employeeExample);

        return count==0;
    }
}
