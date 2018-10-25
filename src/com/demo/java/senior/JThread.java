package com.demo.java.senior;

/**
 * @description: 线程同步
 * @author: maker
 * @create: 2018/10/15
 */
public class JThread {
    public static void main(String[] args) {
        JTicket ticket = new JTicket();
        Thread thread1 = new Thread(ticket, "票贩子A");
        Thread thread2 = new Thread(ticket, "票贩子B");
        Thread thread3 = new Thread(ticket, "票贩子C");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class JTicket implements Runnable {
    private int count = 10;

    @Override
    public void run() {

        // // 法1: 同步代码块
        // synchronized (this) {
        //     for (int i = 0; i < 100; i++) {
        //         try {
        //             Thread.sleep(200);
        //         } catch (InterruptedException e) {
        //             e.printStackTrace();
        //         }
        //         if (count > 0) {
        //             System.out.println(Thread.currentThread().getName() + ", count=" + this.count--);
        //         }
        //     }
        // }

        // 法2: 同步方法
        saleTicket();
    }

    public synchronized void saleTicket() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count > 0) {
                System.out.println(Thread.currentThread().getName() + ", count=" + this.count--);
            }
        }
    }
}
