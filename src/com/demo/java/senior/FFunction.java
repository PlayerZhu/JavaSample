package com.demo.java.senior;

import java.util.function.*;

/**
 * @description: 内建函数式接口
 * @author: maker
 * @create: 2018/10/14
 */
public class FFunction {

    public static void main(String[] args) {
        // 内建函数式接口都位于java.util.function包

        // 1.功能型函数式接口 public interface Function<T,R> { public R apply(T t); }
        Function<Integer, String> fun1 = String::valueOf;
        String str1 = fun1.apply(123456);
        System.out.println(str1.length());
        IntFunction<String> fun2 = String::valueOf;
        String str2 = fun1.apply(12345);
        System.out.println(str2.length());

        // 2.供给型函数式接口 public interface Supplier<T> { public T get(); }
        Supplier<String> supplier = "Hello"::toUpperCase;
        String str3 = supplier.get();
        System.out.println(str3);

        // 3.消费型函数式接口 public interface Consumer<T> { public void accept(T t); }
        Consumer<String> consumer = System.out::println;
        consumer.accept("hello world");

        // 4.断言型函数式接口 public interface Predicate<T> { public boolean test(T t); }
        Predicate<String> predicate = "###hello"::startsWith;
        boolean b = predicate.test("###");
        System.out.println(b);
    }
}
