package com.demo.java.senior;

/**
 * @description: 多线程
 * @author: maker
 * @create: 2018/10/14
 */
public class HThread {
    public static void main(String[] args) {
        // 标准方式
        GMyThread threadA = new GMyThread("线程A");
        GMyThread threadB = new GMyThread("线程B");
        GMyThread threadC = new GMyThread("线程C");
        new Thread(threadA).start();
        new Thread(threadB).start();
        new Thread(threadC).start();

        // 匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world");
            }
        }).start();

        // lambda表达式
        new Thread(() -> System.out.println("Hello world")).start();

        // 线程共享数据
        HTicket1 ticket1 = new HTicket1();
        // ticket1有start方法但调用了thread的start方法【不合理】
        new Thread(ticket1).start();
        new Thread(ticket1).start();
        new Thread(ticket1).start();
        // ticket2没有start方法调用thread的start方法【合理】
        HTicket2 ticket2 = new HTicket2();
        new Thread(ticket2).start();
        new Thread(ticket2).start();
        new Thread(ticket2).start();
    }
}

class HMyThread implements Runnable {
    private String title;

    public HMyThread(String title) {
        this.title = title;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.title + ",i=" + i);
        }
    }
}

class HTicket1 extends Thread {
    private int count = 10;

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (count > 0)
                System.out.println("Ticket1卖票, count=" + count--);
        }
    }
}

class HTicket2 implements Runnable {
    private int count = 10;

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (count > 0)
                System.out.println("Ticket2卖票, count=" + count--);
        }
    }
}