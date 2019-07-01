package com.springboot.mapper;


import com.springboot.domain.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Mapper
public interface EmpMapper extends tk.mybatis.mapper.common.Mapper<Employee> {


}
