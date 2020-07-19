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
 * 思路：维护一个前缀和数组！
 */
class NumArray {
    private int[] sumPrefix; // sumPrefix[i] 代表 [0, i] 之和
    private int N;

    public NumArray(int[] nums) {
        N = nums.length;
        int sum = 0;
        sumPrefix = new int[N];
        for (int i = 0; i < N; i++) {
            sum += nums[i];
            sumPrefix[i] = sum;
        }
    }

    public int sumRange(int i, int j) {
        if (i < 0 || i >= N || j < 0 || j >= N || i > j)
            return 0;

        if (i == 0) return sumPrefix[j];
        return sumPrefix[j] - sumPrefix[i - 1];
    }
}
