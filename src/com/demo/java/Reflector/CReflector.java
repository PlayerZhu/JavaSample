package com.demo.java.Reflector;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @description: 反射知识
 * @author: maker
 * @create: 2018/11/18
 */
public class CReflector {

    @Test
    public void testInvokeMethod() throws Exception {
        String attribute = "name";
        String value = "hello world";
        Class<?> clazz = Class.forName("com.demo.java.Reflector.CPerson");
        Object object1 = clazz.getDeclaredConstructor().newInstance();
        Method setMethod = clazz.getMethod("set" + initCap(attribute), String.class);
        Method getMethod = clazz.getMethod("get" + initCap(attribute));
        setMethod.invoke(object1, value);
        Object ret = getMethod.invoke(object1);
        System.out.println(ret);
        Assert.assertTrue(ret.toString().equalsIgnoreCase(value));
    }

    @Test
    public void testShowFields() throws Exception {
        Class<?> clazz = Class.forName("com.demo.java.Reflector.Dog");
        {
            // 本类和父类可访问属性
            Field[] fields = clazz.getFields();
            for (Field field : fields) {
                System.out.println(field);
            }
        }
        System.out.println("===========================");
        {
            // 本类可访问属性
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field);
            }
        }
        Assert.assertTrue(true);
    }

    @Test
    public void testInvokeAttr() throws Exception {
        Class<?> clazz = Class.forName("com.demo.java.Reflector.CPerson");
        Object object = clazz.getDeclaredConstructor().newInstance();

        // Field nameField = clazz.getField("name"); // 不能访问私有属性
        Field nameField = clazz.getDeclaredField("name"); // 可以访问私有属性，设置setAccessible(true)可操作属性
        Class<?> clsName = nameField.getType();
        System.out.println(clsName.getName());
        System.out.println(clsName.getSimpleName());

        nameField.setAccessible(true); // 设置访问权限
        String name = "张三";
        nameField.set(object, name);
        Object ret = nameField.get(object);
        System.out.println(ret);

        Assert.assertTrue(ret.toString().equals(name));
    }

    public String initCap(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}

class CPerson {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Animal {
    public String name;
}

class Dog extends Animal {
    public Integer age;
}
