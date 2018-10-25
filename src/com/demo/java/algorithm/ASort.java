package com.demo.java.algorithm;

/**
 * @description: 各种排序
 * @author: zhusimu
 * @create: 2018/9/25
 */
public class ASort {
    /**
     * 冒泡排序
     *
     * @param array
     */
    public static void sortBubble(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; ++i) {
            for (int j = i + 1; j < length; ++j) {
                int temp = array[i];
                if (temp > array[j]) {
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }


    /**
     * @description: 测试入口
     * @param args
     */
    public static void main(String[] args) {
        int[] array = new int[]{9, 1, 0, 3, 4, 2, 6, 5, 8, 7};
        sortBubble(array);
        printArray(array);
    }

    public static void printArray(int array[]) {
        for (int i = 0; i < array.length; ++i) {
            System.out.println(array[i]);
        }
    }
}
