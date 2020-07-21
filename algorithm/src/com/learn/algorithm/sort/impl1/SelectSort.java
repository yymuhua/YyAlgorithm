package com.learn.algorithm.sort.impl1;

import com.learn.algorithm.sort.Sort;
import com.learn.algorithm.sort.SortUtils;

/**
 * @author yeyuhua
 * @version 1.0
 * @created 2020/7/20 10:33 下午
 */
public class SelectSort implements Sort {
    @Override
    public int[] sort(int[] nums) {
        int N;
        if (nums == null || (N = nums.length) <= 1) {
            return nums;
        }
        for (int i = 0; i < N - 1; i++) {
            // 每次都确定最小值，放到索引 i 处
            int minIndex = i;
            for (int j = i + 1; j < N; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            SortUtils.swap(nums, i, minIndex);
        }
        return nums;
    }
}
