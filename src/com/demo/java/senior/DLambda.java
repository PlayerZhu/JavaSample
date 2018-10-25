package com.demo.java.senior;

/**
 * @description: Lambda表达式
 * @author: maker
 * @create: 2018/10/13
 */
public class DLambda {
    public static void main(String[] args) {
        IMessage msg1 = new IMessage() {
            @Override
            public void print() {
                System.out.println("hello world");
            }
        };
        msg1.print();

        IMessage msg2 = () -> System.out.println("hello world");
        msg2.print();

        // 一行可省略返回和{}
        IMath math1 = (a, b) -> a + b;
        int r1 = math1.add(10, 20);
        System.out.println(r1);

        // 多行不能省略返回和{}
        IMath math2 = (a, b) -> {
            int n = a + b;
            return n;
        };
        int r2 = math2.add(10, 30);
        System.out.println(r2);
    }
}

interface IMessage {
    public void print();
}

@FunctionalInterface
interface IMath {
    public int add(int x, int y);
}
