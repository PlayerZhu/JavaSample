package com.demo.java.inner;

/**
 * @description: 外部类
 * @author: zhusimu
 * @create: 2018/9/27
 */
public class COuter {

    private static String msg = "hello word!";

    static class CInner{
        public void print(){
            System.out.println(msg);
        }
    }
}
