package com.demo.java.inner;

/**
 * @description: 外部类
 * @author: zhusimu
 * @create: 2018/9/27
 */
public class DOuter {
    private static String msg = "hello word!";

    public void fun(final int num) {
        class Inner {
            private String info = "info";

            public void print() {
                System.out.println("num = " + num);
                System.out.println("msg = " + msg);
            }
        }
        Inner inner = new Inner();
        System.out.println(inner.info);
        inner.print();
    }
}
