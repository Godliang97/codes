package com.baizhi.controller.v1;

import com.baizhi.entity.Pet;
import com.baizhi.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController  //RestController: 专用于restful风格的注解  @controller：专用于传统开发注解
//@Controller
@RequestMapping("/v1/users") //符合使用复数名词
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    //ResponseEntity: springmvc 封装的一个专用于restful 响应类  这个类在响应时可以提供响应的状态码，同时还可以自定义响应头消息
    //HttpStatus: springmvc 封装的一个枚举类型类 这个类中都是网络中的状态码

    /**
     * 查询某个用户详细
     */

    @GetMapping("/{id}")  //@RequestMapping:子类注解  使用GETMapping代表只能使用GET方式访问到当前请求
    //@ResponseBody //将控制器方法返回值转为json
    //注解：@PathVariable：代表在路径中获取请求参数
    public ResponseEntity<User> user(@PathVariable("id") Integer id) {
        log.info("本次id：{}", id);
        User user = new User(id, "小陈", 2300.23, new Date());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /**
     * 用户列表
     */
    @GetMapping
    //@ResponseBody
    public ResponseEntity<List<User>> users() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(21, "小王", 3400.34, new Date()));
        users.add(new User(24, "小黑", 4500.45, new Date()));
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    /**
     * 添加用户
     *
     * @param user
     */
    @PostMapping
    //@ResponseBody
    public ResponseEntity<Void> save(@RequestBody User user) {
        log.info("name:{} salary:{} bir:{}", user.getName(), user.getSalary(), user.getBir());
        //调用业务方法
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); //没有内筒
    }

    /**
     * 更新用户
     */
    @PutMapping
    //@ResponseBody
    public ResponseEntity<Void> update(@PathVariable("id") Integer id, @RequestBody User user) {
        log.info("id:{}", id);
        log.info("name:{} salary:{} bir:{}", user.getName(), user.getSalary(), user.getBir());
        //调用业务方法
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); //没有内筒
    }

    /**
     * 删除用户信息
     */
    @DeleteMapping("/{id}")
    //@ResponseBody
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        log.info("本次id：{}", id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); //没有内容
    }

    /**
     * 获取这个人所有宠物
     */
    @GetMapping("{id}/pets")
    public ResponseEntity<List<Pet>> pets(@PathVariable("id") Integer id) {
        log.info("查询那个人id：{}", id);
        List<Pet> pets = Arrays.asList(new Pet(21, "小狗", 4), new Pet(22, "小猪", 2));
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }

    /**
     * 获取这个人某个宠物
     */
    @GetMapping("/{id}/pets/{pid}")
    public ResponseEntity<Pet> pet(@PathVariable("id") Integer id, @PathVariable("pid") Integer petId) {
        log.info("查询那个人id：{}", id);
        Pet pet = new Pet(21, "小狗", 4);
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }
}
