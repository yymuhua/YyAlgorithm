package com.learn.algorithm.sort.impl;

import com.learn.algorithm.sort.Sort;
import com.learn.algorithm.sort.SortUtils;

import java.awt.font.NumericShaper;
import java.util.Arrays;

/**
 * 堆排序：先构建大顶堆，然后每次都交换堆顶和堆尾，去除堆尾之后，将问题规模缩小1，重复操作。
 * @author yymuhua
 * @create 2020-03-12 22:03
 */
public class HeapSort implements Sort {
    @Override
    public int[] sort(int[] nums) {
        if(nums == null || nums.length <= 1)
            return nums;
        int N = nums.length;
        // 1 构建大顶堆
        buildHeap(nums);
        // 2 每次将堆顶取出，剩余部分重新调整为大顶堆
        while(N > 0) {
            SortUtils.swap(nums, 0, N - 1);
            N--;
            adjustHeap(nums, 0, N);
        }
        return nums;
    }

    /**
     * 由无序的数组构建大顶堆
     * @param nums
     */
    private void buildHeap(int[] nums) {
        int N = nums.length;
        // 从后往前的第一个非叶子节点为起点，不断调整直到根
        for(int i = N / 2 - 1; i >= 0; i--) {
            adjustHeap(nums, i, N);
        }
    }

    /**
     * 调整堆的部分使该部分仍然保持大顶堆的特性：确保start是start -> end的最大值
     * @param nums
     * @param start
     * @param end
     */
    private void adjustHeap(int[] nums, int start, int end) {
        int largest = start;
        int left = 2 * start + 1;  // 左节点
        int right = 2 * start + 2; // 右节点
        if(left < end && nums[left] > nums[largest]) {
            largest = left;
        }
        if(right < end && nums[right] > nums[largest]) {
            largest = right;
        }
        if(largest != start) {
            SortUtils.swap(nums, start, largest);
            adjustHeap(nums, largest, end);
        }
    }
}
