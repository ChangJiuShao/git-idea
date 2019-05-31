package com.ssm.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.dao.Msg;
import com.ssm.domain.Employee;
import com.ssm.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EmpController {


    @Autowired
    EmpService service;
/*    @RequestMapping(value = "/emp")
    public String getEmp(@RequestParam(value = "page",defaultValue = "1") Integer page,
                         Model model)  {

//使用pageHelper插件 start方法 表示从page页开始 每页显示五条
        PageHelper.startPage(page,5);
        //startPage方法后紧跟的查询就是分页查询
        List<Employee> employees = service.selectAll();
        //使用PageInfo来封装分页查询的结果
        //PageInfo封装分页的详细信息 包括分页的数据
        //我们把分页的数据和期望导航栏每次显示的页码数 传给pageInfo
        PageInfo<Employee> pageInfo = new PageInfo<>(employees,5);
model.addAttribute("pageInfo",pageInfo);
        return "list";
    }*/


    //定义返回json数据的映射

    @ResponseBody
    @RequestMapping(value = "/emp",method = RequestMethod.GET)
    public Msg getEmps(@RequestParam(value = "page",defaultValue = "1") Integer page){

//使用pageHelper插件 start方法 表示从page页开始 每页显示五条
       PageHelper.startPage(page, 5);
        //startPage方法后紧跟的查询就是分页查询
        List<Employee> employees = service.selectAll();
        //使用PageInfo来封装分页查询的结果
        //PageInfo封装分页的详细信息 包括分页的数据
        //我们把分页的数据和期望导航栏每次显示的页码数 传给pageInfo

        PageInfo<Employee> pageInfo = new PageInfo<>(employees,5);

        return  Msg.success().add("pageInfo",pageInfo);

    }


@ResponseBody
@RequestMapping(value = "/emp",method = RequestMethod.POST)
    public  Msg addEmp(Employee employee){
        service.insertEmp(employee);
      return Msg.success();
      /*
      * ename=zhangsan&email=123&gender=man&did=3
      * Employee{eid=null, email='123', ename='zhangsan', gender='man', dId=null, department=null}

       * */
    }



    @RequestMapping("/checkUser")
    @ResponseBody
    public  boolean checkUser(String ename){
        boolean checkUser = service.checkUser(ename);
        return checkUser;

    }

}
