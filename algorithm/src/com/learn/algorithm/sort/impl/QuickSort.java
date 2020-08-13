package com.learn.algorithm.sort.impl;

import com.learn.algorithm.sort.Sort;

/**
 * 快速排序：选择一个元素，放到合适的位置，再将左右部分分别进行快速排序
 *
 * @author yymuhua
 * @create 2020-03-12 19:52
 */
public class QuickSort implements Sort {
    @Override
    public int[] sort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        int N = nums.length;
        quickHelper(nums, 0, N);
        return nums;
    }

    private void quickHelper(int[] nums, int start, int end) {
        if (end - start <= 1) {
            return;
        }
        // 将索引 index 位置的元素放到合适的位置
        // 如果选择其他的位置只需要多一步swap即可
        int keyIndex = start;
        int keyNum = nums[keyIndex];
        int left = start;
        int right = end - 1;
        while (left < right) {
            // 空位在left，需要找一个小于等于keyNum的元素填掉
            while (left < right && nums[right] > keyNum) right--;
            if (left < right) {
                // 此时的nums[right] <= keyNum，可以填入left
                nums[left] = nums[right];
                left++;
            }

            // 空位在 right，需要找一个大于keyNum的元素填掉
            while (left < right && nums[left] <= keyNum) left++;
            if (left < right) {
                // 此时nums[left] > keyNum，可以填入
                nums[right] = nums[left];
                right--;
            }
        }
        // left == right
        keyIndex = left;
        nums[keyIndex] = keyNum;
        quickHelper(nums, start, keyIndex); // 左边排序
        quickHelper(nums, keyIndex + 1, end); // 右边排序
    }
}
