package com.learn.algorithm.sort.impl;

import com.learn.algorithm.sort.Sort;
import com.learn.algorithm.sort.SortUtils;

/**
 * 选择排序：每次都选择一个最小的元素放到当前的头部
 * @author yymuhua
 * @create 2020-03-12 18:59
 */
public class SelectSort implements Sort {
    @Override
    public int[] sort(int[] nums) {
        if(nums == null || nums.length <= 1)
            return nums;
        int N = nums.length;
        for(int i = 0; i < N - 1; i++) {
            // 每次都选择一个最小的数放到 i 的位置上
            int maxIndex = i;
            for(int j = i + 1; j < N; j++) {
                if(nums[j] < nums[maxIndex]) {
                    maxIndex = j;
                }
            }
            SortUtils.swap(nums, i, maxIndex);
        }
        return nums;
    }
}
