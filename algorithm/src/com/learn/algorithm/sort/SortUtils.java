package com.learn.algorithm.sort;

/**
 * 排序所用工具类
 *
 * @author yymuhua
 * @create 2020-03-12 18:42
 */
public class SortUtils {
    /**
     * 交换arr数组中index1和index2位置的元素
     *
     * @param arr
     * @param index1
     * @param index2
     */
    public static void swap(int[] arr, int index1, int index2) {
        if (index1 == index2) return;
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
