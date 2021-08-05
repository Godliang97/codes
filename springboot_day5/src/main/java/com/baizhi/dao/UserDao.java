package com.baizhi.dao;

import com.baizhi.entity.User;

import java.util.List;

public interface UserDao {

    //查询所有
    List<User> findAll();

    //保存用户信息
    void save(User user);
}
