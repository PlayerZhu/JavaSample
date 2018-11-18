package com.demo.java.senior2;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

/**
 * @description: 输入输出流
 * @author: maker
 * @create: 2018/11/5
 */
public class BInOutPut {

    @Test
    public void testPrintStream() throws FileNotFoundException {
        String path = "/Users/maker/JavaProjects/info.txt";
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File(path)));
        String name = "zhangshan";
        int age = 20;
        double salary = 3000.3798;
        printWriter.printf("name:%s, age:%d, salary:%5.2f", name, age, salary);
        printWriter.close();
    }

    @Test
    public void testScanner() throws FileNotFoundException {
        // !!!除了二进制文件对拷，信息输出使用打印流，输入使用Scanner
        String path = "/Users/maker/JavaProjects/info.txt";
        String format = "\\d{4}-\\d{2}-\\d{2}";
        Scanner scanner = new Scanner(new FileInputStream(new File((path))));
        scanner.useDelimiter("\n");
        while (scanner.hasNext()) {
            String line = scanner.next();
            System.out.println(line);
        }
        scanner.close();
    }
}
