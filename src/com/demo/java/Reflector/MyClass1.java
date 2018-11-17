package com.demo.java.Reflector;

/**
 * @description: 测试反射类
 * @author: maker
 * @create: 2018/11/14
 */
public class MyClass1 {

    private String name;

    public MyClass1() {
        this.name = "default";
    }

    public MyClass1(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println("name: " + this.name);
    }
}
