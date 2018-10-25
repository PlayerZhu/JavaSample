package com.demo.java.senior;

/**
 * @description: 多线程
 * @author: maker
 * @create: 2018/10/14
 */
public class GThread {
    public static void main(String[] args) {

        // java实现多线程(单继承局限)
        // 1.继承Thread类
        // 2.实现Runnable,Callable接口【推荐】

        GMyThread threadA = new GMyThread("线程A");
        GMyThread threadB = new GMyThread("线程B");
        GMyThread threadC = new GMyThread("线程C");
        threadA.start();
        threadB.start();
        threadC.start();
    }
}

class GMyThread extends Thread {

    private String title;

    public GMyThread(String title) {
        this.title = title;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.title + ",i=" + i);
        }
    }
}
