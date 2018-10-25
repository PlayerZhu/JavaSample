package com.demo.java.algorithm;

/**
 * @description: 二分查找
 * @author: zhusimu
 * @create: 2018/9/24
 */
public class BSearch {

    /**
     * 二分查找法
     *
     * @param array
     * @param key
     * @param from
     * @param to
     * @return
     */
    public static int binarySearch(int array[], int key, int from, int to) {
        if (from > to)
            return -1;
        int middle = (from + to) / 2;
        if (key == array[middle])
            return middle;
        else if (key < array[middle])
            return binarySearch(array, key, from, middle - 1);
        else
            return binarySearch(array, key, middle + 1, to);
    }

    /**
     * @description: 测试入口
     * @param args
     */
    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int key = 5;
        int index = binarySearch(array, key, 0, array.length - 1);
        System.out.println("index: " + index);
    }
}