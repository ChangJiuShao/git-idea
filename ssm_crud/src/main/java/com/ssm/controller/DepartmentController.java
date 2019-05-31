package com.ssm.controller;

import com.ssm.dao.DepartmentMapper;
import com.ssm.dao.Msg;
import com.ssm.domain.Department;
import com.ssm.service.DepartmentService;
import com.ssm.service.impl.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DepartmentController {
    @Autowired
    DepartmentService service;


    @ResponseBody
    @RequestMapping("/deps")
    public Msg getDeps(){

        List<Department> departments = service.selectDeps();

        return Msg.success().add("deps",departments);
    }

}
