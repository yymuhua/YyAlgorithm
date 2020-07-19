package com.learn.algorithm.dp.substring;

/**
 * 最大子数组乘积：
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字）。
 * 关键：需要维护两个DP数组，因为存在负数的情况
 *
 * @author yymuhua
 * @create 2020-03-29 15:02
 */
public class MaxmumProduct {
    /**
     * 求数组的最大子数组乘积
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];
        int N = nums.length;
        // 需要维护两个DP数组，因为有可能nums[i]为负数乘上前面的负数乘积反而成为最大值
        int[] minDP = new int[N]; // minDP[i] 代表以 nums[i] 结尾的最小值
        int[] maxDP = new int[N]; // maxDP[i] 代表以 nums[i] 结尾的最大值
        minDP[0] = nums[0];
        maxDP[0] = nums[0];
        int res = maxDP[0];
        for (int i = 1; i < N; i++) {
            int min = minDP[i - 1] * nums[i]; // 前面的最小乘积可能因为乘上了nums[i]反而变为最大的了
            int max = maxDP[i - 1] * nums[i]; // 前面的最大乘积可能因为乘上了nums[i]反而变为最小的了
            maxDP[i] = Math.max(max, Math.max(min, nums[i]));
            minDP[i] = Math.min(min, Math.min(max, nums[i]));
            res = Math.max(maxDP[i], res);
        }
        return res;
    }
}
