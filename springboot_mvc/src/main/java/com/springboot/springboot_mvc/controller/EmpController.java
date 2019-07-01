package com.springboot.springboot_mvc.controller;

import com.springboot.springboot_mvc.dao.DepartmentDao;
import com.springboot.springboot_mvc.dao.EmployeeDao;
import com.springboot.springboot_mvc.domain.Department;
import com.springboot.springboot_mvc.domain.Employee;
import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.util.Collection;
import java.util.Map;

@Controller
public class EmpController {
    @Autowired
    EmployeeDao dao;
    @Autowired
    DepartmentDao departmentDao;
    @GetMapping("emps")
    public  String getEmp(Model model){
        Collection<Employee> employees = dao.getAll();
        model.addAttribute("emps",employees);
        return "list";
    }
@GetMapping("/emp")
    public String addPage(Map<String, Object> map){

    Collection<Department> departments = departmentDao.getDepartments();
    map.put("depts",departments);
    return "add";

}
@PostMapping("/emp")
public String addEmp(Employee employee){

        dao.save(employee);
        return "redirect:/emps";

}

@DeleteMapping("/emp/{id}")
public String deleteEmp(@PathVariable("id") Integer id){

        dao.delete(id);
        return "redirect:/emps";

}

@GetMapping("emp/{id}")
public String updatePage(@PathVariable("id") Integer id, Model model, Map<String,Object> map){

    Employee employee = dao.get(id);
    //页面发送get请求会携带需要修改的用户的id 使用id查询到对应用户后保存  进而回显
    model.addAttribute("emp",employee);
    //同时还得查出depts 回显
    Collection<Department> departments = departmentDao.getDepartments();
    map.put("depts",departments);

    //页面发送请求后 来到员工添加页面  我们使用的方式是员工添加和修改是一个页面
        return "add";

}


@PutMapping("/emp")
public  String update(Employee employee){

        dao.save(employee);
        return "redirect:/emps";
}


}
