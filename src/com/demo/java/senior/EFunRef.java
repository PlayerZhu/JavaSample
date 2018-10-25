package com.demo.java.senior;

/**
 * @description: 方法引用
 * @author: maker
 * @create: 2018/10/14
 */
public class EFunRef {
    public static void main(String[] args) {
        // 静态方法引用
        IFunRef1<Integer, String> ifn1 = String::valueOf; // 相当于 ifn1 = (p)-> String.valueOf(p);
        String str1 = ifn1.toString(10000); // 相当于 String.valueOf(10000);
        System.out.println(str1.length());

        // 实例方法引用
        String str2 = "hello world";
        IFunRef2<String> ifn2 = str2::toUpperCase; // 相当于 ifn2 = ()-> str2.toUpperCase();
        String str3 = ifn2.toUpper(); // 相当于 str2.toUpperCase();
        System.out.println(str3);

        // 类方法引用(!!!可由本身设置内容，或者说本身实例化)
        String str4 = "hello";
        String str5 = "Hello";
        IFunRef3<String, Integer> ifn3 = String::compareTo; // 相当于 ifn3 = (p1, p2) -> p1.compareTo(p2);
        Integer n1 = ifn3.compare(str4, str5); // 相当于 str4.compareTo(str5);
        System.out.println(n1);

        // 类构造方法
        IFunRef4<String, Integer, Person> ifn4 = Person::new; // 相当于 ifn4 = (s, i) -> new Person(s, i);
        Person p = ifn4.create("zhangshan", 20); // 相当于 new Person("zhangshan", 20);
        System.out.println(p);
    }
}

@FunctionalInterface
interface IFunRef1<T, R> {
    public R toString(T p);
}

@FunctionalInterface
interface IFunRef2<R> {
    public R toUpper();
}

@FunctionalInterface
interface IFunRef3<T, R> {
    public R compare(T p1, T p2);
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

@FunctionalInterface
interface IFunRef4<T1, T2, R> {
    public R create(T1 p1, T2 p2);
}