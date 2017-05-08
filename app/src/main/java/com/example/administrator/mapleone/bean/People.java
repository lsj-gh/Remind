package com.example.administrator.mapleone.bean;

/**
 * Created by Administrator on 2017/5/5 0005.
 */

public class People {
    private String name;
    private int age;

    public People(String name, int age) {
        this.age = age;
        this.name = name;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
