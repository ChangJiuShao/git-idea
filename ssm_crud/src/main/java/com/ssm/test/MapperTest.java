package com.ssm.test;

import com.ssm.dao.DepartmentMapper;
import com.ssm.dao.EmployeeMapper;
import com.ssm.domain.Department;
import com.ssm.domain.Employee;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class MapperTest {

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    SqlSession sqlSession;

    @Autowired
    EmployeeMapper employee;

    @Test
    public  void  testCRUD(){

       /* departmentMapper.insertSelective(new Department(null,"开发部"));
        departmentMapper.insertSelective(new Department(null,"研发部"));*/
       /* Department department = departmentMapper.selectByPrimaryKey(1);
        System.out.println(department);*/
       //sqlSessionTemplate.
       // employee.insertSelective(new Employee(null,"111233@qq.com","tom","man",1));

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        for (int i = 0; i < 1000; i++) {

            String uu = UUID.randomUUID().toString().substring(0, 5);
            mapper.insertSelective(new Employee(null,uu+"111233@qq.com",uu,"man",1));

        }
        System.out.println("success");
    }




}
