package com.learn.algorithm.sort.impl;

import com.learn.algorithm.sort.Sort;
import com.learn.algorithm.sort.SortUtils;

/**
 * 冒泡排序：每次都将最小的元素浮动到头部
 *
 * @author yymuhua
 * @create 2020-03-12 18:38
 */
public class BubbleSort implements Sort {
    @Override
    public int[] sort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        int N = nums.length;
        for (int i = 0; i < N - 1; i++) {
            // 每次最小的元素都会上浮到索引 i 处
            boolean sorted = true; // 一次交换都没有发生表示排序已经完成
            for (int j = N - 1; j > i; j--) {
                if (nums[j - 1] > nums[j]) {
                    SortUtils.swap(nums, j - 1, j);
                    sorted = false;
                }
            }
            if (sorted) {
                break;
            }
        }
        return nums;
    }
}
