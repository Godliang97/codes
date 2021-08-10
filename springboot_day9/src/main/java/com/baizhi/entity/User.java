package com.baizhi.entity;

public class User {

    private Integer id;
    private String name;
    private String realname;
    private String password;
    private Boolean gender;

    public User() {
    }

    public User(Integer id, String name, String realname, String password, Boolean gender) {
        this.id = id;
        this.name = name;
        this.realname = realname;
        this.password = password;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", realname='" + realname + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                '}';
    }


}
