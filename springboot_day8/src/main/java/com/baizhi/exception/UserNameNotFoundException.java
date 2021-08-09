package com.baizhi.exception;

//自定义异常 用户名不存在
public class UserNameNotFoundException extends RuntimeException{

    public UserNameNotFoundException(String message) {
        super(message);
    }
}
