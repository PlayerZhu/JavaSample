package com.demo.java.basic;


import java.io.*;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

/**
 * @description: 入口函数
 * @author: maker
 * @create: 2018/10/18
 */
public class Program {
    public static void main(String[] args) throws Exception {
        // // 日期转字符串
        // testDate2String();

        // // 字符串转日期
        // testString2Date();

        // // math.round去小数(错误的四舍五入)
        // testRound();

        // // 正确的四舍五入
        // testRoundEx();

        // // 随机数
        // testRandom();

        // // 资源文件或本地化
        // testResourceBundle();

        // 内存流使用(转大写)
        testMemorySteam();
        testMemoryStrem2();
    }

    public static void testDate2String() {
        String fmt = "yyyy-MM-dd HH:mm:ss.SSS";
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        Date date = new Date();
        String now = sdf.format(date);
        System.out.println(now);
    }

    public static void testString2Date() throws ParseException {
        String fmt = "yyyy-MM-dd HH:mm:ss.SSS";
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        String str = "2018-08-18 23:11:12.345";
        Date date = sdf.parse(str);
        System.out.println(date);
    }

    public static void testRound() {
        System.out.println(Math.round(234.51)); // 235
        System.out.println(Math.round(234.5)); // 235
        System.out.println(Math.round(-234.51)); // -235
        System.out.println(Math.round(-234.5)); // -234(!!!此处有坑)
        System.out.println(Math.round(-2.345 * 100)); // -235
    }

    public static void testRoundEx() {
        double value1 = round(234.5678, 2);
        System.out.println(value1);

        double value2 = round(-2.3451, 2);
        System.out.println(value2);

        double value3 = round(-2.345, 2);
        System.out.println(value3);
    }

    public static void testRandom() {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            System.out.print(random.nextInt(100) + ",");// 0-99随机数
        }
    }

    public static void testResourceBundle() {
        // 资源文件尽量和类名称命名一致,如果放在包里面则需要加包名称
        ResourceBundle resourceBundle = ResourceBundle.getBundle("com.demo.java.basic.Program");
        System.out.println(resourceBundle.getString("welcome.info1"));
        System.out.println(resourceBundle.getString("welcome.info2"));

        Locale en = new Locale("en", "US");
        ResourceBundle enResource = ResourceBundle.getBundle("com.demo.java.basic.Program", en);
        String enMsg = enResource.getString("welcome.info");
        String enContent = MessageFormat.format(enMsg, "bob", "jack");
        System.out.println(enContent);

        Locale zh = new Locale("zh", "CN");
        ResourceBundle zhResource = ResourceBundle.getBundle("com.demo.java.basic.Program", zh);
        String zhMsg = zhResource.getString("welcome.info");
        String zhContent = MessageFormat.format(zhMsg, "张三", "李四");
        System.out.println(zhContent);
    }

    public static void testMemorySteam() throws IOException {
        String msg = "hello world!!!";
        InputStream input = new ByteArrayInputStream(msg.getBytes());
        OutputStream output = new ByteArrayOutputStream();
        int byTemp = 0; // !!!注意read()方法返回byte
        while ((byTemp = input.read()) != -1) {
            output.write(Character.toUpperCase(byTemp));
        }
        System.out.println(output); // 调用toString方法
        input.close();
        output.close();
    }

    public static void testMemoryStrem2() throws IOException {
        String msg = "hello world!!!";
        InputStream input = new ByteArrayInputStream(msg.getBytes());
        OutputStream output = new ByteArrayOutputStream();
        byte[] data = new byte[2];
        int len = 0; // !!!注意read(byte[])方法返回length
        while ((len = input.read(data)) != -1) {
            output.write(data, 0, len);
        }
        System.out.println(output); // 调用toString方法
        input.close();
        output.close();
    }

    /**
     * 小数四舍五入
     *
     * @param number 原始操作数
     * @param scale  保留的小数位
     * @return 正确的四舍五入结果
     */
    public static double round(double number, int scale) {
        double pow = Math.pow(10, scale);
        return Math.round(number * pow) / pow;
    }
}
