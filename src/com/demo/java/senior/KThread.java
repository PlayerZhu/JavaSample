package com.demo.java.senior;

/**
 * @description: 多线程：生产者和消费者模型
 * @author: maker
 * @create: 2018/10/15
 */
public class KThread {
    public static void main(String[] args) {
        KData data = new KData();
        new Thread(new KProvider(data)).start();
        new Thread(new KConsumer(data)).start();
    }
}

class KProvider implements Runnable {
    private KData data;

    public KProvider(KData data) {
        this.data = data;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            if (i % 2 == 0) {
                this.data.set("老朱", "是个好人");
            } else {
                this.data.set("LY", "是个人渣");
            }
        }
    }
}

class KConsumer implements Runnable {
    private KData data;

    public KConsumer(KData data) {
        this.data = data;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(this.data.get());
        }
    }
}

class KData {
    private String title;
    private String note;

    // flag=true: 允许生产，不能消费
    // flag=false: 允许消费，不能生产
    private boolean flag = true;

    public synchronized void set(String title, String note) {
        // 在消费，等待
        if (this.flag == false) {
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.title = title;
        this.note = note;
        this.flag = false;
        super.notify();
    }

    public synchronized String get() {
        // 在生产，等待
        if (this.flag == true) {
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.flag = true;
        super.notify();
        return this.title + "," + this.note;
    }
}