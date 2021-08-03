package com.baizhi;

import com.baizhi.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testFinaAll() {
        userDao.findAll().forEach(user -> System.out.println(user.getName()));
    }
}
