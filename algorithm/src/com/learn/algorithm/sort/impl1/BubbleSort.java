package com.learn.algorithm.sort.impl1;

import com.learn.algorithm.sort.Sort;
import com.learn.algorithm.sort.SortUtils;

/**
 * @author yeyuhua
 * @version 1.0
 * @created 2020/7/20 10:39 下午
 */
public class BubbleSort implements Sort {
    @Override
    public int[] sort(int[] nums) {
        int N;
        if (nums == null || (N = nums.length) <= 1) {
            return nums;
        }
        for (int i = 0; i < N - 1; i++) {
            boolean sorted = true;
            for (int j = N - 1; j > i; j--) {
                if (nums[j - 1] > nums[j]) {
                    SortUtils.swap(nums, j - 1, j);
                    sorted = false;
                }
            }
            if (sorted) {
                break ;
            }
        }
        return nums;
    }
}
