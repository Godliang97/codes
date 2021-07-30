package com.baizhi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 测试属性的注入
 */
@RestController
public class InjectionController {

    @Value("${name}")
    private String name;

    @Value("${age}")
    private Integer age;

    @Value("${price}")
    private Double price;

    @Value("${birthday}")
    private Date birthday;

    @Value("${sex}")
    private Boolean sex;

    @Value("${qqs}")
    private String[] qqs;

    @Value("${lists}")
    private List<String> lists;

    @Value("#{${maps}}")  //注意：在注入map集合时，配置文件中药使用json格式赋值 在注入时必须使用 “#{${xxx}}” 进行获取
    private Map<String, String> maps;

    @RequestMapping("inject")
    public String inject() {
        System.out.println("inject ok");
        System.out.println("name=" + name);
        System.out.println("age=" + age);
        System.out.println("price=" + price);
        System.out.println("birthday=" + birthday);
        System.out.println("sex=" + sex);
        for (String qq : qqs) {
            System.out.println("qq=" + qq);
        }
        System.out.println("====================");
        System.out.println("遍历lists");
        lists.forEach(li -> System.out.println("li=" + li));
        System.out.println("====================");
        System.out.println("遍历map");
        maps.forEach((key, value) -> System.out.println("key=" + key + " value=" + value));
        return "inject ok";
    }

}
