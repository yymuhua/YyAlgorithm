package com.learn.algorithm.dfs;

/**
 * 平均分配
 * @author yeyuhua
 * @version 1.0
 * @created 2020/8/8 5:14 下午
 */
public class Dividing {
    private static int min;
    private static int sum;
    /**
     * 有n个礼物，每个礼物都有价值nums[i]，将其平均分成两堆，多余的丢弃，求需要丢弃的最小价值！
     * @param nums
     * @param n > 1
     * @return
     */
    public int dividing(int[] nums, int n) {
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        helper(nums, 0, 0, 0);
        return min;
    }
    /**
     * sum1：第一堆的价值和；sum2：第二堆的价值和
     */
    private void helper(int[] nums, int index, int sum1, int sum2) {
        if (index == nums.length) {
            if (sum1 == sum2) {
                min = Math.min(min, sum - 2 * sum1);
            }
            return ;
        }

        // 丢弃
        helper(nums, index + 1, sum1, sum2);

        // 分到第一堆
        helper(nums, index + 1, sum1 + nums[index], sum2);

        // 分到第二堆
        helper(nums, index + 1, sum1, sum2 + nums[index]);
    }
}
