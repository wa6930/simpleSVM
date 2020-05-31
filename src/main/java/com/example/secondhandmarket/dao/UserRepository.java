package com.example.secondhandmarket.dao;

import com.example.secondhandmarket.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {
    public Users findByName(String name);
    /* 删除对应用户的名字*/
    public Users deleteByName(String name);
}