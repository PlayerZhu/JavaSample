package com.demo.java.designpattern;

import java.util.Observable;
import java.util.Observer;

/**
 * @description: 观察者模式
 * @author: maker
 * @create: 2018/10/21
 */
public class AObserver {
    public static void main(String[] args) {
        Peron peronA = new Peron("张三");
        Peron peronB = new Peron("李四");
        Peron peronC = new Peron("王五");
        House house = new House(7000.00);
        house.addObserver(peronA);
        house.addObserver(peronB);
        house.addObserver(peronC);
        house.setPrice(9000.00);
    }
}

class Peron implements Observer {
    private String name;

    public Peron(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof House) {
            if (arg instanceof Double) {

                System.out.println("[房价上涨]" + this.name + ",关注到新价格: " + arg);
            }
        }
    }
}

class House extends Observable {
    private double price;

    public House(double price) {
        this.price = price;
    }

    public void setPrice(double price) {
        if (price > this.price) {
            super.setChanged();
            super.notifyObservers(price);
        }
        this.price = price;
    }
}
