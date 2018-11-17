package com.demo.java.senior1;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @description: 多线程
 * @author: maker
 * @create: 2018/10/14
 */
public class IThread {
    public static void main(String[] args) throws Exception {
        // Callable实现多线程与Runnable实现接口都唯一区别就是能返回值
        FutureTask<String> task = new FutureTask<>(new ITicket1());
        new Thread(task).start();
        String result = task.get();
        System.out.println(result);

        // 设置线程名称1: public Thread(Runnable target, String name);
        // 设置线程名称2: public final void setName(String name);
        // 获取线程名称: public final String getName();
        // 获取当前执行线程: public static Thread currentThread();
    }
}

class ITicket1 implements Callable<String> {
    private int count = 10;

    @Override
    public String call() throws Exception {
        for (int i = 0; i < 10; i++) {
            if (count > 0)
                System.out.println("Ticket1卖票, count=" + count--);
        }
        return "票卖完了，下次再来...";
    }
}
