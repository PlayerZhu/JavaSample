package com.demo.java.designpattern;

import org.junit.Test;

/**
 * @description: 工厂设计模式
 * @author: maker
 * @create: 2018/11/18
 */
public class BFactory {

    @Test
    public void testFactory() {
        IMessage iMessage = Factory.getInstance(Message.class);
        iMessage.print();
        IFruit iFruit = Factory.getInstance(Apple.class);
        iFruit.eat();
    }
}

class Factory {

    private Factory() {
    }

    public static <T> T getInstance(Class<?> clazz) {
        try {
            T object = (T) clazz.getDeclaredConstructor().newInstance();
            return object;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

interface IMessage {
    void print();
}

interface IFruit {
    void eat();
}

class Message implements IMessage {
    @Override
    public void print() {
        System.out.println("Message print()");
    }
}

class Apple implements IFruit {
    @Override
    public void eat() {
        System.out.println("Apple eat()");
    }
}



