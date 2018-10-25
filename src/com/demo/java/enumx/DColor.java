package com.demo.java.enumx;


/**
 * @description:
 * @author: zhusimu
 * @create: 2018/9/19
 */
public enum DColor implements DBehaviour {
    RED("红色", 1),
    YELLOW("黄色", 2),
    GREEN("绿色", 3),
    BLUE("蓝色", 4);

    private String name;
    private int index;

    private DColor(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public void print() {
        System.out.println(this.index + ":" + this.name);
    }

    @Override
    public String getInfo() {
        return this.name;
    }
}

interface DBehaviour {
    void print();
    String getInfo();
}