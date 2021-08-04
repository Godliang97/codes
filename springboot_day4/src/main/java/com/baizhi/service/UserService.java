package com.baizhi.service;

public interface UserService {

    void save(String name);

    void delete(Integer id);

    String find(String name);
}
