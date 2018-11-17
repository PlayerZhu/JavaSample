package com.demo.java.senior1;

/**
 * @description: 范型示例
 * @author: maker
 * @create: 2018/10/13
 */
public class BGeneric<T> {

    private T x;
    private T y;

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }

    /**
     * 测试入口
     *
     * @param args
     */
    public static void main(String[] args) {
        BGeneric<Double> g1 = new BGeneric<Double>();
        g1.setX(13.0);
        g1.setY(39.3);
        // print(g1); // 设置了下限不能调用
        BGeneric<String> g2 = new BGeneric<String>();
        g2.setX("hello");
        g2.setY("world");
        print(g2);

        Integer[] array1 = fun(1, 2, 3, 4, 5);
        for (int i : array1) {
            System.out.println(i);
        }
        String[] array2 = fun("hello", "world");
        for (String str : array2) {
            System.out.println(str);
        }
    }

    private static void print(BGeneric<? super String> generic) {
        String msg = "x=" + generic.getX() + ",y=" + generic.getY();
        System.out.println(msg);
    }

    private static <T> T[] fun(T... args) {
        return args;
    }
}
