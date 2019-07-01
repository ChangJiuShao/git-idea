package com.mapper.dao;

import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

/*
* 接口的拓展
* 提供拓展功能的接口
*
* */
public interface UpdateMapper<T>  {
//如果自定义的是用于更新的方法就用@UpdateProvider注解
//自定义其他的方法要用对应的注解
//第一个参数是实现具体方法功能的类的class对象 第二个参数是固定写法
@UpdateProvider(type =UpdateMapper.class ,method ="dynamicSQL")
 void  updateAccount (List<T> list);

}
