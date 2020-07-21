package com.learn.algorithm.sort.impl1;

import com.learn.algorithm.sort.Sort;
import com.learn.algorithm.sort.SortUtils;

/**
 * @author yeyuhua
 * @version 1.0
 * @created 2020/7/20 10:45 下午
 */
public class InsertSort implements Sort {
    @Override
    public int[] sort(int[] nums) {
        int N;
        if (nums == null || (N = nums.length) <= 1) {
            return nums;
        }
        for (int i = 1; i < N; i++) {
            int value = nums[i];
            int aimIndex = i - 1;
            while (aimIndex >= 0) {
                if (nums[aimIndex] > value) {
                    nums[aimIndex + 1] = nums[aimIndex];
                    aimIndex--;
                } else {
                    break ;
                }
            }
            nums[aimIndex + 1] = value;
        }
        return nums;
    }
}
