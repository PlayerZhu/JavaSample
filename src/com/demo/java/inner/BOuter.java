package com.demo.java.inner;

/**
 * @description: 外部类
 * @author: zhusimu
 * @create: 2018/9/27
 */
public class BOuter {

    private String msg = "hello word!";
    public String getMsg(){
        return this.msg;
    }

    public void fun(){
        BInner inner = new BInner(this);
        inner.print();
    }
}
class BInner {

    private BOuter outer;

    public BInner(BOuter outer){
        this.outer = outer;
    }

    public void print(){
        System.out.println(this.outer.getMsg());
    }
}