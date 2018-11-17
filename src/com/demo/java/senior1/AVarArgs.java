package com.demo.java.senior1;

/**
 * @description: 可变参数
 * @author: maker
 * @create: 2018/10/13
 */
public class AVarArgs {

    /**
     * 测试入口函数
     * @param args
     */
    public static void main(String[] args) {

        funA();
        funA(1, 2, 3, 4);
        funA(new int[]{2, 4, 6, 8});

        funB("hello", 1, 2, 3, 4);
    }

    public static void funA(int... args) {
        int sum = 0;
        for (int i = 0; i < args.length; i++) {
            sum += args[i];
        }
        System.out.println("sum=" + sum);
    }

    public static void funB(String msg, int... args) {
        int sum = 0;
        for (int i = 0; i < args.length; i++) {
            sum += args[i];
        }
        System.out.println("msg=" + msg + ",sum" + sum);
    }
}
