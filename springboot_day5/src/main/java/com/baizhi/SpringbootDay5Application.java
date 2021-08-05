package com.baizhi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.baizhi.dao")
public class SpringbootDay5Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDay5Application.class, args);
    }

}
