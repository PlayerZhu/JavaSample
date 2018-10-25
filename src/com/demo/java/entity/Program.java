package com.demo.java.entity;

/** 修饰符		本类	    包		子类	    外部类
 *  public		Y		Y		Y		Y
 *  protected	Y		Y		Y		N
 *  无			Y		Y		N		N
 *  private		Y		N		N		N
 */

/**
 * @description: 测试入口
 * @author: zhusimu
 * @create: 2018/9/27
 */
public class Program {
    public static void main(String [] args){

        Department board = new Department(1000, "董事会");
        Department technical = new Department(1001, "技术部");
        Department finance = new Department(1002, "财务部");
        Department marketing = new Department(1003, "市场部");

        Employee zhangshan = new Employee(7261, "张三");
        Employee lisi = new Employee(7610, "李四");
        Employee wangwu = new Employee(7549, "王五");
        Employee zhaoliu = new Employee(7016, "赵六");
        Employee lilei = new Employee(7430, "Lilei");
        Employee hanmeimei = new Employee(7901, "Hanmeimei");

        Role boss = new Role(1301, "老板");
        Role manager = new Role(1302, "经理");
        Role staff = new Role(1303, "职员");

        Privilege entry = new Privilege(1401, "入职", "staff:entry");
        Privilege quit = new Privilege(1402, "离职", "staff:quit");
        Privilege promote = new Privilege(1403, "升职", "stuff:promote");
        Privilege fire = new Privilege(1404, "辞退", "leader:fire");
        Privilege raise = new Privilege(1405, "涨薪", "salary:raise");

        // 设置部门员工
        board.setEmployees(new Employee[]{zhangshan});
        technical.setEmployees(new Employee[]{lisi, wangwu});
        finance.setEmployees(new Employee[]{zhaoliu});
        marketing.setEmployees(new Employee[]{lilei, hanmeimei});

        // 设置员工部门
        zhangshan.setDepartment(board);
        lisi.setDepartment(technical);
        wangwu.setDepartment(technical);
        zhaoliu.setDepartment(finance);
        lilei.setDepartment(marketing);
        hanmeimei.setDepartment(marketing);

        // 设置员工角色
        zhangshan.setRoles(new Role[]{boss});
        lisi.setRoles(new Role[]{manager, staff});
        wangwu.setRoles(new Role[]{staff});
        zhaoliu.setRoles(new Role[]{manager, staff});
        lilei.setRoles(new Role[]{manager});
        hanmeimei.setRoles(new Role[]{staff});

        // 设置角色部门
        boss.setDepartments(new Department[]{board});
        manager.setDepartments(new Department[]{technical, finance, marketing});
        staff.setDepartments(new Department[]{technical, finance, marketing});

        // 设置角色权限
        boss.setPrivileges(new Privilege[]{fire, raise});
        manager.setPrivileges(new Privilege[]{quit, fire, raise});
        staff.setPrivileges(new Privilege[]{entry, quit, promote});

        // 设置权限角色
        entry.setRoles(new Role[]{staff});
        quit.setRoles(new Role[]{staff, manager});
        promote.setRoles(new Role[]{staff});
        fire.setRoles(new Role[]{manager, boss});
        raise.setRoles(new Role[]{manager, boss});


        // 根据员工找部门，角色，权限
        Employee employee = zhaoliu;
        // System.out.println(employee.getInfo());
        System.out.println(employee.getInfo() + " " + employee.getDepartment().getInfo());
        for (int i = 0; i < employee.getRoles().length; ++i) {
            Role role = employee.getRoles()[i];
            System.out.println("\t|-" + role.getInfo());
            for (int j = 0; j < role.getPrivileges().length; ++j) {
                Privilege privilege = role.getPrivileges()[j];
                System.out.println("\t\t|-" + privilege.getInfo());
            }
        }
        System.out.println();

        // 根据角色找所有部门，部门的所有员工
        Role role = manager;
        System.out.println(role.getInfo());
        Department[] departments = role.getDepartments();
        for (int i = 0; i < departments.length; ++i) {
            Department dept = departments[i];
            System.out.println("\t|-" + dept.getInfo());
            for (int j = 0; j < dept.getEmployees().length; ++j) {
                Employee emp = dept.getEmployees()[j];
                Role r = null;
                Role[] roles = emp.getRoles();
                for (int k = 0; k < roles.length; ++k) {
                    if (role.equals(roles[k])) {
                        r = role;
                        break;
                    }
                }
                System.out.println("\t\t|-" + emp.getInfo() + (r == null ? "" : "(" + r.getName() + ")"));
            }
        }
        System.out.println();

        // 根据权限找所有角色，角色对应的部门，每个部门员工
        Privilege privilege = quit;
        System.out.println(privilege.getInfo());
        Role[] roles = privilege.getRoles();
        for (int i = 0; i < roles.length; ++i) {
            System.out.println("\t|-" + roles[i].getInfo());
            Department[] departments1 = roles[i].getDepartments();
            for (int j = 0; j < departments1.length; ++j) {
                Department dept2 = departments1[j];
                System.out.println("\t\t|-" + dept2.getInfo());
                Employee[] employees = dept2.getEmployees();
                for (int k = 0; k < employees.length; ++k) {
                    System.out.println("\t\t\t|=" + employees[k].getInfo());
                }
            }
        }
    }
}
