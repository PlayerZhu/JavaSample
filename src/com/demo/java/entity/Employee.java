package com.demo.java.entity;

/**
 * @description: 员工
 * @author: zhusimu
 * @create: 2018/9/27
 */
public class Employee {
    private int id;
    private String name;
    private Department department; // 一个员工一个部门
    private Role[] roles; // 一个员工多个角色

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return this.department;
    }

    public void setRoles(Role[] roles) {
        this.roles = roles;
    }

    public Role[] getRoles() {
        return this.roles;
    }

    public String getInfo() {
        return "[员工]id = " + this.id + ", name = " + this.name;
    }
}
