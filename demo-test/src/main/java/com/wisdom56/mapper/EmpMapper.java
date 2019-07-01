package com.wisdom56.mapper;

import com.wisdom56.domain.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;



@Mapper
public interface EmpMapper<T> extends tk.mybatis.mapper.common.Mapper<T> {
}
