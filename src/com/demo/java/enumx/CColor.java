package com.demo.java.enumx;

/**
 * @description: 枚举包含方法
 * @author: zhusimu
 * @create: 2018/9/19
 */
public enum CColor {
    RED("红色", 1),
    YELLOW("黄色", 2),
    GREEN("绿色", 3),
    BLUE("蓝色", 4);

    private String name;
    private int index;

    private CColor(String name, int index) {
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

    public static String getName(int index) {
        for (CColor c : CColor.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.index + "-" + this.name;
    }
}
