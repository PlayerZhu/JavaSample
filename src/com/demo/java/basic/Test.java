package com.demo.java.basic;

/**
 * @description: 测试
 * @author: maker
 * @create: 2018/10/29
 */
public class Test {
    public static void main(String[] args) {
        double[] data = new double[]{1, 3, 5, 2, 4, 6, 6, 7, 10, 20, 2, 17, 22, 5, 8, 100, 29, 16, 29, 41};
        calcAvg(data);
        calcMax(data);
    }

    public static void calcAvg(double[] data) {
        if (data.length < 10) {
            return;
        }
        double sum = 0.0;
        double sum_head = 0.0;
        double avg = 0.0;
        for (int i = 0; i < data.length; ++i) {
            sum = sum += data[i];
            if (i >= 10) {
                sum_head = sum_head + data[i - 10];
                avg = (sum - sum_head) / 10.0;
                System.out.println("i=" + i + "\tsum=" + sum + "\tsum_head=" + sum_head + "\tavg=" + avg);
            }
        }
    }

    public static void calcMax(double[] data) {
        if (data.length < 10) {
            return;
        }
        double[] cmp_data = new double[10];
        for (int i = 0; i < 10; ++i) {
            cmp_data[i] = data[i];
        }
        for (int j = 10; j < data.length; ++j) {
            double max = max(cmp_data);
            System.out.println("j=" + j + "\tmax=" + max);

            for (int k = 0; k < 9; ++k) {
                cmp_data[k] = cmp_data[k + 1];
            }
            cmp_data[9] = data[j];
        }
    }

    public static double max(double[] data) {
        double max_num = data[0];
        for (int i = 0; i < 10; ++i) {
            if (data[i] > max_num) {
                max_num = data[i];
            }
        }
        return max_num;
    }
}
