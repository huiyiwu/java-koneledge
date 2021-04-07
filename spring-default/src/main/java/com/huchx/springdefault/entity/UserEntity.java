package com.huchx.springdefault.entity;

public class UserEntity {
    private String name = "huchx";
    private Integer age = 19;

    public UserEntity(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public UserEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
