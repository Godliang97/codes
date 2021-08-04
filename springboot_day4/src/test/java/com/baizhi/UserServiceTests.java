package com.baizhi;

import com.baizhi.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTests extends BaticTests {

    @Autowired
    private UserService userService;

    @Test
    public void testSave() {
        userService.save("小陈");
    }

    @Test
    public void testDelete() {
        userService.delete(21);
    }

    @Test
    public void restFind() {
        String name = userService.find("xiaochen");
        System.out.println(name);
    }
}
