package com.demo.java.senior1;

/**
 * @description: 线程隔离数据对象(减少引用传递)
 * @author: maker
 * @create: 2018/10/24
 */
public class MThreadLocal {
    public static void main(String[] args) {
        new Thread(() -> {
            MMessage msg = new MMessage();
            msg.setNote("this is a test!");
            MUtil.set(msg);
            new MMessageConsumer().print();
        }, "ThreadA").start();

        new Thread(() -> {
            MMessage msg = new MMessage();
            msg.setNote("这是一个测试!");
            MUtil.set(msg);
            new MMessageConsumer().print();
        }, "ThreadB").start();
    }
}

class MMessage {
    private String note;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

class MMessageConsumer {
    public void print() {
        System.out.println(Thread.currentThread().getName() + " = " + MUtil.get().getNote());
    }
}

class MUtil {
    private static ThreadLocal<MMessage> threadLocal = new ThreadLocal<>();

    public static void set(MMessage message) {
        threadLocal.set(message);
    }

    public static MMessage get() {
        return threadLocal.get();
    }
}
