package com.mybatis.mbg.test;

import com.mybatis.mbg.domain.Account;
import com.mybatis.mbg.mapper.AccountMapper;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import tk.mybatis.mapper.entity.Config;
import tk.mybatis.mapper.mapperhelper.MapperHelper;

import java.io.InputStream;
import java.util.List;

public class MbgTest {

    public static void main(String[] args) {

        InputStream in = MbgTest.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder  builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory build = builder.build(in);
        SqlSession sqlSession = build.openSession();
        //**********************************************
        //使用通用mapper所要增加的配置
        MapperHelper mapperHelper = new MapperHelper();
        Configuration configuration = sqlSession.getConfiguration();
        mapperHelper.processConfiguration(configuration);
        //***************************************
        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        List<Account> accounts = mapper.selectAll();
        for (Account account : accounts) {
            System.out.println(account);
        }

    }
}
