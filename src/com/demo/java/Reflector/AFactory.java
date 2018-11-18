package com.demo.java.Reflector;

import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * @description: 反射示例1
 * @author: maker
 * @create: 2018/11/14
 */
public class AFactory {

    @Test
    public void testFactory(){
        APerson object1 = AReflectorFactory.getInstance(APerson.class);
        object1.print();
        APerson object2 = AReflectorFactory.getInstance(APerson.class, "Hello world!!");
        object2.print();
    }
}

class AReflectorFactory {

    public static <T> T getInstance(Class<T> clzz) {
        try {
            return clzz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T getInstance(Class<T> clzz, String string) {
        try {
            Constructor<T> constructor = clzz.getConstructor(string.getClass());
            return constructor.newInstance(string);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

class APerson {

    private String name;

    public APerson() {
        this.name = "default";
    }

    public APerson(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println("name: " + this.name);
    }
}
