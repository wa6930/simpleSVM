package com.example.secondhandmarket.service;

import com.example.secondhandmarket.dao.UserRepository;
import com.example.secondhandmarket.domain.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional    //声明式事务
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    /* 获取全部用户 */
    @Override
    public List<Users> findAll() {
        return userRepository.findAll();
    }

    /* 根据用户名查找用户 */
    @Override
    public Users getAUser(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public void addUser(Users user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(String name) {
        userRepository.deleteByName(name);
    }

}
