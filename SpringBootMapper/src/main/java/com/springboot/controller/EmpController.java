package com.springboot.controller;


import com.springboot.domain.Employee;
import com.springboot.domain.Result;
import com.springboot.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/demo")
public class EmpController {

@Autowired
   EmpService empService;

    @GetMapping("/emp")
    public  Result<List<Employee>> getEmp(Model model){
        List<Employee> employees =empService.findAll();
        Result< List<Employee>> result = new Result<>();
        result.setData(employees);
        result.setMessage("查询成功");
        model.addAttribute(result);
        return result;
    }

    @PostMapping("/emp")
    public Result addEmp(Employee employee){

        empService.save(employee);
        Result result = new Result();
        result.setCode(200);
        result.setMessage("插入用户"+employee.getId()+"成功");
        return result;

    }

    @PutMapping("/emp")
    public  Result update(Employee employee){

        empService.update(employee);
        Result result = new Result();
        result.setCode(200);
        result.setMessage("用户更新成功");
        return result;
    }

    @DeleteMapping("/emp/{id}")
    public Result deleteEmp(@PathVariable("id") Integer id){

        empService.delete(id);
        Result result = new Result();
        result.setCode(200);
        result.setMessage("用户删除成功");
        return result;

    }

}
