package com.learn.algorithm.sort.impl;

import com.learn.algorithm.sort.Sort;

import java.util.Arrays;

/**
 * 归并排序：将大数组分割为两个小数组，对小数组进行归并排序，再将两个有序的小数组合并
 * @author yymuhua
 * @create 2020-03-12 21:16
 */
public class MergeSort implements Sort {

    @Override
    public int[] sort(int[] nums) {
        if(nums == null || nums.length <= 1)
            return nums;
        int N = nums.length;
        int mid = N / 2;
        int[] nums1 = Arrays.copyOfRange(nums, 0, mid);
        int[] nums2 = Arrays.copyOfRange(nums, mid, N);
        return mergeTwo(sort(nums1), sort(nums2));
    }

    /**
     * 合并两个有序的数组
     * @param nums1
     * @param nums2
     * @return
     */
    private int[] mergeTwo(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0) return nums2;
        if(nums2 == null || nums2.length == 0) return nums1;
        int N1 = nums1.length;
        int N2 = nums2.length;
        int[] res = new int[N1 + N2];
        int p1 = 0;
        int p2 = 0;
        while(p1 < N1 && p2 < N2) {
            if(nums1[p1] <= nums2[p2]) {
                res[p1 + p2] = nums1[p1];
                p1++;
            }else {
                res[p1 + p2] = nums2[p2];
                p2++;
            }
        }
        // 要么 p1 == N1 要么 p2 == N2
        while(p1 < N1) {
            res[p1 + p2] = nums1[p1];
            p1++;
        }
        while(p2 < N2) {
            res[p1 + p2] = nums2[p2];
            p2++;
        }
        return res;
    }
}
