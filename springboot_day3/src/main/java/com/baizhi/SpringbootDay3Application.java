package com.baizhi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.baizhi.dao") //用在类上 作用：用来扫描dao接口所在的包 同时将所有dao接口在工厂中创建对象
public class SpringbootDay3Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDay3Application.class, args);
    }

}
