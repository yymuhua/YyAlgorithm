package com.learn.algorithm.sort.impl;

import com.learn.algorithm.sort.Sort;

/**
 * 希尔排序：每次都将数组分为等间隔的若干序列，对序列进行插入排序，完成后间隔减半
 * @author yymuhua
 * @create 2020-03-12 19:24
 */
public class ShellSort implements Sort {
    @Override
    public int[] sort(int[] nums) {
        if(nums == null || nums.length <= 1)
            return nums;
        int N = nums.length;
        int gap = N / 2;
        while(gap > 0) {
            // 前 gap 个元素相当于是
            for(int i = gap; i < N; i++) {
                int curr = nums[i];
                int aimIndex = i - gap;
                while(aimIndex >= 0) {
                    if(nums[aimIndex] > curr) {
                        // 后移一位（此处一个位置间隔为 gap）
                        nums[aimIndex + gap] = nums[aimIndex];
                    }else {
                        break;
                    }
                    aimIndex -= gap;
                }
                nums[aimIndex + gap] = curr;
            }
            gap /= 2;
        }
        return nums;

    }
}
