package com.learn.algorithm.dp;

/**
 * @author yymuhua
 * @create 2020-03-28 17:11
 */
public class SumRange {
    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-4, 5});
        System.out.println(numArray.sumRange(0, 0));
    }
}

/**
 * leetcode 303
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * nums.length > 0
 * 思路：维护一个前缀和数组！
 */
class NumArray {
    private int[] prefixSum; // sumPrefix[i] 代表 [0, i] 之和
    private int N;

    public NumArray(int[] nums) {
        N = nums.length;
        prefixSum = new int[N];
        prefixSum[0] = 0;
        for (int i = 1; i < N; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (i < 0 || i >= N || j < 0 || j >= N || i > j) {
            return 0;
        }

        if (i == 0) {
            return prefixSum[j];
        }
        return prefixSum[j] - prefixSum[i - 1];
    }
}
