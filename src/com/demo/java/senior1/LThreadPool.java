package com.demo.java.senior1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @description: 线程池
 * @author: maker
 * @create: 2018/10/17
 */
public class LThreadPool {
    public static void main(String[] args) {
        // fun1();
        // fun2();
        // fun3();
        fun4();
    }

    private static void fun1() {
        // 创建无限大小线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            int index = i;
            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName() + ",i=" + index);
            });
        }
        executorService.shutdown();
    }

    private static void fun2() {
        // 创建单线程线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            int index = i;
            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName() + ",i=" + index);
            });
        }
        executorService.shutdown();
    }

    private static void fun3() {
        // 创建固定大小线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            int index = i;
            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName() + ",i=" + index);
            });
        }
        executorService.shutdown();
    }

    private static void fun4() {
        // 创建定时调度线程池
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        for (int i = 0; i < 10; i++) {
            int index = i;
            executorService.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + ",i=" + index);
                }
            }, 3, 2, TimeUnit.SECONDS); // 3秒后执行，每2秒执行一次
        }
    }
}
