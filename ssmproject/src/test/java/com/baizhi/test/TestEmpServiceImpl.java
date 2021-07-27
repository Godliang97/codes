package com.baizhi.test;

import com.baizhi.entity.Emp;
import com.baizhi.service.EmpService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class TestEmpServiceImpl {

    public static void main(String[] args) {
        //1.运行工厂
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        //2.工厂中获取对象
        EmpService empService = (EmpService) context.getBean("empServiceImpl");

        empService.save(new Emp(null, "小陈", new Date(), 23.23));

        //3.调用方法
        empService.findAll().forEach(emp -> System.out.println(emp));
    }
}
