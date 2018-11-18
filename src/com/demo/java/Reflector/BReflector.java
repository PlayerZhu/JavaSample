package com.demo.java.Reflector;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.util.Date;

/**
 * @description: 范型基础
 * @author: maker
 * @create: 2018/11/18
 */
public class BReflector {

    @Test
    public void testClass() throws Exception {
        // 第一种方式产生Class对象: 需要导入包，需要实例化对象
        Class<?> cls = new Date().getClass(); // 产生对象
        System.out.println(cls.getName());
        // 第二种方式产生Class对象: 需要导入包，不需要实例化对象
        cls = Date.class;
        System.out.println(cls.getName());
        // 第三种方式产生Class对象: 不需要导入包，不需要实例化对象
        cls = Class.forName("java.util.Date");
        System.out.println(cls.getName());

        Date date = (Date) cls.getDeclaredConstructor().newInstance();
        System.out.println(date);
    }

    @Test
    public void testNewInstance() throws Exception {
        Class<?> clazz = BPerson.class;
        System.out.println("获取构造函数列表");
        Constructor constructors[] = clazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println("通过构造函数创建对象");
        Constructor<?> cons1 = clazz.getConstructor();
        Constructor<?> cons2 = clazz.getConstructor(String.class, Integer.class);
        Object object1 = cons1.newInstance();
        Object object2 = cons2.newInstance("zhangshan", 30);
        System.out.println(object1);
        System.out.println(object2);

        System.out.println("通过新办法创建对象");
        Object object3 = clazz.getDeclaredConstructor().newInstance();
        Object object4 = clazz.getDeclaredConstructor(String.class, Integer.class).newInstance("lisi", 20);
        System.out.println(object3);
        System.out.println(object4);

    }
}

class BPerson {
    private String name;
    private Integer age;

    public BPerson() {
        this.name = "default";
        this.age = 0;
    }

    public BPerson(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "BPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
