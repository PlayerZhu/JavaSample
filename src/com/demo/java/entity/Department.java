package com.demo.java.entity;

/**
 * @description: 部门
 * @author: zhusimu
 * @create: 2018/9/27
 */
public class Department {
    private int id;
    private String name;

    private Employee[] employees; // 一个部门多个员工

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    public Employee[] getEmployees() {
        return this.employees;
    }

    public String getInfo() {
        return "[部门]id = " + this.id + ", name = " + this.name;
    }
}
