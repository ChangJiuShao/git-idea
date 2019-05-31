package com.ssm.test;

import com.github.pagehelper.PageInfo;
import com.ssm.domain.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

/*
* 模拟发送请求
*
* */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration//获取springMvc IOC
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:springMVC.xml"})
public class MvcTest {
    //传入springMvc的IOC
    @Autowired
    WebApplicationContext context;
    //虚拟mvc请求 获取处理结果
    MockMvc mockMvc;
            @Before
            public void init(){
            //初始化
                mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
            }

            @Test
            public  void  testMvc() throws Exception {

                MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/emp").param("page", "1")).andReturn();

                MockHttpServletRequest request = result.getRequest();
                PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
                System.out.println("获取当前页码"+pageInfo.getPageNum());
                System.out.println("获取总页码"+pageInfo.getPages());
                System.out.println("获取总记录数"+pageInfo.getTotal());
                //获取数据
                List<Employee> list = pageInfo.getList();
                for (Employee employee : list) {
                    System.out.println("ID"+employee.getdId()+"==="+employee.getEname());
                }
               //获取要连续显示的页码
                int[] nums = pageInfo.getNavigatepageNums();
                for (int num : nums) {
                    System.out.println(num);
                }

            }

}
