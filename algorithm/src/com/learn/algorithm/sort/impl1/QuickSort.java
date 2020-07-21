package com.learn.algorithm.sort.impl1;

import com.learn.algorithm.sort.Sort;

/**
 * @author yeyuhua
 * @version 1.0
 * @created 2020/7/20 11:46 下午
 */
public class QuickSort implements Sort {
    @Override
    public int[] sort(int[] nums) {
        int N;
        if (nums == null || (N = nums.length) <= 1) {
            return nums;
        }
        quickHelper(nums, 0, N);
        return nums;
    }
    private void quickHelper(int[] nums, int start, int end) {
        if (end - start <= 1) {
            return ;
        }
        int aimValue = nums[start];
        // 将aimValue放到合适的位置，使其前面的所有数小于等于它，后面的数大于它
        int left = start;
        int right = end - 1;
        while (left < right) {
            // left 是空位，从right往左搜索找到第一个小于aimValue的，填入
            while (left < right && nums[right] > aimValue) {
                right--;
            }
            if (left < right) {
                nums[left] = nums[right];
                left++;
            }
            // right 是空位，从left往右搜索填入
            while (left < right && nums[left] <= aimValue) {
                left++;
            }
            if (left < right) {
                nums[right] = nums[left];
                right--;
            }
        }
        // left == right
        nums[left] = aimValue;
        quickHelper(nums, start, left);
        quickHelper(nums, left + 1, end);
    }
}
