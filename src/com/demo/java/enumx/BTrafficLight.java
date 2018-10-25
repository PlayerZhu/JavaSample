package com.demo.java.enumx;


/**
 * @description: 测试Switch
 * @author: zhusimu
 * @create: 2018/9/19
 */
public class BTrafficLight {

    private BSignal color = BSignal.READ;

    public void change(){
        switch (color){
            case READ:
                color= BSignal.YELLOW;
                break;
            case YELLOW:
                color=BSignal.GREEN;
                break;
            case GREEN:
                color=BSignal.READ;
                break;
        }
    }
}

enum BSignal {
    READ,YELLOW,GREEN
}





