package com.demo.java.senior2;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @description:
 * @author: maker
 * @create: 2018/11/25
 */
public class BAnnotation {
    @Test
    public void testAnnotation() {
        Annotation[] annotations = Member.class.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        MyAnnotation annotation = Company.class.getAnnotation(MyAnnotation.class);
        System.out.println("name=" + annotation.name() + ",age=" + annotation.age());

    }
}

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    String name(); // 属性

    int age() default 10; // 属性
}

@MyAnnotation(name = "zhangshan")
class Member {

}

@MyAnnotation(name = "科技有限公司", age = 5)
class Company {

}