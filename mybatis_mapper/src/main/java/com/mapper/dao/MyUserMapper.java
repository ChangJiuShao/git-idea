package com.mapper.dao;

import com.mapper.domain.Account;
import org.springframework.stereotype.Repository;

/*
*
* 接口的拓展
* 我们最终使用的接口
*
* */
@Repository
public interface MyUserMapper extends MyMapper<Account> {
}
