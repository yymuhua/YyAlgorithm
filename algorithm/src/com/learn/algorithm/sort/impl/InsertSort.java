package com.learn.algorithm.sort.impl;

import com.learn.algorithm.sort.Sort;

/**
 * 插入排序：每次都将元素nums[i]放到前面有序数组的合适位置中
 *
 * @author yymuhua
 * @create 2020-03-12 19:05
 */
public class InsertSort implements Sort {

    @Override
    public int[] sort(int[] nums) {
        if (nums == null || nums.length <= 1)
            return nums;
        int N = nums.length;
        for (int i = 1; i < N; i++) {
            // 每次都将元素nums[i]放到前面 0 -> i - 1 的有序数组合适位置中
            // 具体的方式为把大于curr的都后移一格，直到遇到第一个小于等于curr的，把curr插入到它后面
            int curr = nums[i];
            int aimIndex = i - 1;
            while (aimIndex >= 0) {
                if (nums[aimIndex] > curr) {
                    // 后移一个位置
                    nums[aimIndex + 1] = nums[aimIndex];
                } else {
                    // 此处即为 nums[i] 的合适位置
                    break;
                }
                aimIndex--;
            }
            // 此时 aimIndex 为 -1 或为第一个小于等于curr的位置
            nums[aimIndex + 1] = curr;
        }
        return nums;
    }
}
