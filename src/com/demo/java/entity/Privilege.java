package com.demo.java.entity;

/**
 * @description: 权限
 * @author: zhusimu
 * @create: 2018/9/27
 */
public class Privilege {
    private int id;
    private String title;
    private String flag;
    private Role[] roles; // 一种权限可多个角色拥有

    public Privilege(int id, String title, String flag) {
        this.id = id;
        this.title = title;
        this.flag = flag;
    }

    public void setRoles(Role[] roles) {
        this.roles = roles;
    }

    public Role[] getRoles() {
        return this.roles;
    }

    public String getInfo() {
        return "[权限]id = " + this.id + ", title = " + this.title + ", flag = " + this.flag;
    }
}
