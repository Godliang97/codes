package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.List;

public interface UserService {

    //查询所有
    List<User> findAll();

    //保存信息
    void save(User user);
}
