package com.demo.java.inner;

/**
 * @description: 内部类
 * @author: zhusimu
 * @create: 2018/9/27
 */
public class AOuter {

    private String msg = "hello word!";

    class Inner1{
        public void print(){
            System.out.println(msg);
        }
    }

    private class Inner2{
        public void print(){
            System.out.println(AOuter.this.msg);
        }
    }

    public void fun(){
        Inner1 inner1 = new Inner1();
        inner1.print();
        
        Inner2 inner2 = new Inner2();
        inner2.print();
    }
}
