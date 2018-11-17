package com.demo.java.Reflector;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @description: 反射示例1
 * @author: maker
 * @create: 2018/11/14
 */
public class Sample1 {

    public static void main(String[] args) {
        MyClass1 object1 = Sample1.getInstance(MyClass1.class);
        object1.print();
        MyClass1 object2 = Sample1.getInstance(MyClass1.class, "Hello world!!");
        object2.print();
    }

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
