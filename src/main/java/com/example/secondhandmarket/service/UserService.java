package com.example.secondhandmarket.service;

import com.example.secondhandmarket.domain.Users;
import java.util.List;

public interface UserService {

    /* 查询所有用户 */
    public List<Users> findAll();

    /* 根据用户名查找用户 */
    public Users getAUser(String name);

    /* 添加用户 */
    public void addUser(Users users);
    /*删除用户*/
    public void deleteUser(String name);
}
