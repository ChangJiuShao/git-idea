package com.mapper.domain;

import javax.persistence.*;
import java.io.Serializable;

/*
*
* 此实体类命名出现了错误  但是由于绑定了配置文件  就不再做修改了
* */

@Table(name = "account")
//@table注解对应实体类与表名  name属性表示自定义表名
// 如果不加此注解默认的规则是实体类的类名第一个字母小写对应表名
public class Account implements Serializable {
//属性和表中的字段也有默认规则 例如 userName  ==> user_name
// 如果不符合默认规则 就可以使用@Column 注解 name属性就是表中的字段

//使用通用mapper的SelectByPrimaryKey() 如果不再主键的对应实体类属性上加@Id注解
//默认使用把所用字段都加入where子句 形成联合主键
//SELECT id,name,money FROM account WHERE id = ? AND name = ? AND money = ?
//加上@Id后才是根据主键进行查询
//SELECT id,name,money FROM account WHERE id = ?
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;
    @Column(name = "name")
    private String name;
    private Double money;
    private Integer age;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                ", age=" + age +
                '}';
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Account() {
    }

    public Account(Integer id, String name, Double money) {
        this.id = id;
        this.name = name;
        this.money = money;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
