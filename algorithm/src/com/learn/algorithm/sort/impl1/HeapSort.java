package com.learn.algorithm.sort.impl1;

import com.learn.algorithm.sort.Sort;
import com.learn.algorithm.sort.SortUtils;

/**
 * @author yeyuhua
 * @version 1.0
 * @created 2020/7/21 12:01 上午
 */
public class HeapSort implements Sort {
    @Override
    public int[] sort(int[] nums) {
        int N;
        if (nums == null || (N = nums.length) <= 1) {
            return nums;
        }
        buildHeap(nums, N);
        for (int i = N - 1; i > 0; i--) {
            SortUtils.swap(nums, 0, i);
            adjustHeap(nums, 0, i);
        }
        return nums;
    }

    private void buildHeap(int[] nums, int N) {
        for (int i = N / 2 - 1; i >= 0; i--) {
            adjustHeap(nums, i, N);
        }
    }
    private void adjustHeap(int[] nums, int start, int end) {
        int left = 2 * start + 1;
        int right = 2 * start + 2;
        int maxIndex = start;
        if (left < end && nums[left] > nums[maxIndex]) {
            maxIndex = left;
        }
        if (right < end && nums[right] > nums[maxIndex]) {
            maxIndex = right;
        }
        if (maxIndex != start) {
            SortUtils.swap(nums, start, maxIndex);
            adjustHeap(nums, maxIndex, end);
        }
    }
}
