package com.ssm.service.impl;

import com.ssm.dao.DepartmentMapper;
import com.ssm.domain.Department;
import com.ssm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    //spring 只支持接口类型的注入
    @Autowired
    DepartmentMapper mapper;
    @Override
    public List<Department> selectDeps() {
        return mapper.selectByExample(null);
    }
}
