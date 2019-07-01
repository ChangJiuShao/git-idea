package com.mapper.dao;

import tk.mybatis.mapper.common.base.BaseDeleteMapper;
import tk.mybatis.mapper.common.base.BaseInsertMapper;
import tk.mybatis.mapper.common.base.BaseSelectMapper;
import tk.mybatis.mapper.common.base.BaseUpdateMapper;

/*
* 接口的拓展
*
* 继承通用mapper原有的基本接口和自定义的用于实现增加的拓展方法的接口
*
* */
public interface MyMapper<T> extends BaseDeleteMapper<T>, BaseInsertMapper<T>, BaseSelectMapper<T>, BaseUpdateMapper<T>,UpdateMapper<T>
 {
}
