package com.demo.java.inner;

/**
 * @description: 测试入口
 * @author: zhusimu
 * @create: 2018/9/27
 */
public class Program {
    public static void main(String [] args){
        // testA1();
        // testA2();
        // testB();
        // testC();
        testD();
    }

    public static void testA1(){
        AOuter.Inner1 inner = new AOuter().new Inner1();
        inner.print();
    }

    public static void testA2(){
        AOuter outer = new AOuter();
        outer.fun();
    }

    public static void testB(){
        BOuter outer = new BOuter();
        outer.fun();
    }

    public static void testC(){
        COuter.CInner inner = new COuter.CInner();
        inner.print();
    }

    public static void testD(){
        DOuter outer = new DOuter();
        outer.fun(100);
    }
}
