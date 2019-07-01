package com.mapper.dao;

import org.apache.ibatis.mapping.MappedStatement;
import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.mapperhelper.EntityHelper;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;
import tk.mybatis.mapper.mapperhelper.SqlHelper;

import java.util.Set;

/*
*
* 真正实现拓展接口的类
* 要注意的是该类实现的不是含有方法的自定义的扩展接口
* 而是继承MapperTemplate 并是实现其有参构造器
*
* */
public class UpdateImpl  extends MapperTemplate {


    public UpdateImpl(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }



    /*方法名必须和自定义接口的方法名保持一致 参数页必须是 MappedStatement
    目标SQL：        实现的功能就是批量更新
        <foreach collection="list" item="record" separator=";" >
            UPDATE tabple_emp
            <set>
                emp_name=#{record.empName},
                emp_age=#{record.empAge},
                emp_salary=#{record.empSalary},
            </set>
            where emp_id=#{record.empId}
        </foreach>
     */
    public  String updateAccount (MappedStatement statement){

        //1.创建StringBuilder用于拼接SQL语句的各个组成部分
        StringBuilder builder = new StringBuilder();

        //2.拼接foreach标签
        builder.append("<foreach collection=\"list\" item=\"record\" separator=\";\" >");

        //3.获取实体类对应的Class对象
        Class<?> entityClass = super.getEntityClass(statement);

        //4.获取实体类在数据库中对应的表名  实体类中包含表名@Table
        String tableName = super.tableName(entityClass);

        //5.生成update子句
        String updateClause = SqlHelper.updateTable(entityClass, tableName);

        builder.append(updateClause);

        builder.append("<set>");

        //6.获取所有字段信息
        Set<EntityColumn> columns = EntityHelper.getColumns(entityClass);

        String idColumn = null;
        String idHolder = null;

        for (EntityColumn entityColumn : columns) {

            boolean isPrimaryKey = entityColumn.isId();

            //7.判断当前字段是否为主键
            if(isPrimaryKey) {

                //8.缓存主键的字段名和字段值
                idColumn = entityColumn.getColumn();

                //※返回格式如:#{record.age,jdbcType=NUMERIC,typeHandler=MyTypeHandler}
                idHolder = entityColumn.getColumnHolder("record");

            }else {

                //9.使用非主键字段拼接SET子句
                String column = entityColumn.getColumn();
                String columnHolder = entityColumn.getColumnHolder("record");

                builder.append(column).append("=").append(columnHolder).append(",");

            }

        }
        builder.append("</set>");

        //10.使用前面缓存的主键名、主键值拼接where子句
        builder.append("where ").append(idColumn).append("=").append(idHolder);

        builder.append("</foreach>");

        //11.将拼接好的字符串返回
        return builder.toString();

        //*****要进行批量更新还要在url后加上&allowMultiQueries=true
    }



}
