package com.example.secondhandmarket.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/* 用户类 */
@Data
@Getter
@Setter
@Entity //表示是该类的是一个实体
@Table(name = "users") //表示该类对应的表名是 users
public class Users {

    @Id //该字段是主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") //表示id变量对应表中的userid参数
    private int id;      //用户id

    @Column(name = "username")
    private String name;    //用户名

    @Column(name = "password")
    private String password;    //密码

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;

    }

    public String getPassword() {
        return this.password;
    }
    public String getName(){
        return this.name;
    }
    public Users(){
        this.name = "";
        this.password = "";
    }
    public Users(String name,String pwd){
        this.name = name;
        this.password = pwd;
    }
    public Users(String name,String pwd,int id){
        this.id = id;
        this.name = name;
        this.password = pwd;
    }


}

