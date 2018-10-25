package com.demo.java.entity;

/**
 * @description: 角色
 * @author: zhusimu
 * @create: 2018/9/27
 */
public class Role {
    private int id;
    private String name;

    private Department[] departments; // 多个部门具有此角色
    private Privilege[] privileges; // 一个角色多个权限

    public Role(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDepartments(Department[] departments) {
        this.departments = departments;
    }

    public Department[] getDepartments() {
        return this.departments;
    }

    public void setPrivileges(Privilege[] privileges) {
        this.privileges = privileges;
    }

    public Privilege[] getPrivileges() {
        return this.privileges;
    }

    public String getInfo() {
        return "[角色]id = " + this.id + ", name = " + this.name;
    }
}
