package com.baizhi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @RequestMapping("demo")
    public String demo() {
        System.out.println("demo hello");
        System.out.println("demo ok");
        return "demo hello";
    }
}
