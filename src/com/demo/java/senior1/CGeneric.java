package com.demo.java.senior1;

/**
 * @description: 范型示例
 * @author: maker
 * @create: 2018/10/13
 */
public class CGeneric<T extends Number> {
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
        print(g1); // 设置了上限

        BGeneric<Integer> g2 = new BGeneric<Integer>();
        g2.setX(10);
        g2.setY(398);
        print(g2); // 设置了上限
    }

    private static void print(BGeneric<? extends Number> generic) {
        String msg = "x=" + generic.getX() + ",y=" + generic.getY();
        System.out.println(msg);
    }
}
