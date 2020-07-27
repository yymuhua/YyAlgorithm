package com.yyh;

import com.learn.algorithm.*;

import java.util.*;

/**
 * @author yeyuhua
 * @version 1.0
 * @created 2020/7/24 12:37 上午
 */
public class Solution {

    public int rob2(int[] nums) {
        int N;
        if (nums == null || (N = nums.length) == 0) {
            return 0;
        }
        // 从 0 偷到 n - 2
        int from0Ton2 = robHelper(nums, 0, N - 2);
        // 从 1 偷到 n - 1
        int from1Ton1 = robHelper(nums, 1, N - 1);
        return Math.max(from0Ton2, from1Ton1);
    }

    /**
     * [start, end] 区间能偷得的最大金额
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private int robHelper(int[] nums, int start, int end) {
        if (start > end) {
            return 0;
        }
        // dp[i] 代表从 i 开始偷能偷得的最大金额
        int dp1 = nums[end];
        int dp2 = 0;
        for (int i = end - 1; i >= start; i--) {
            int temp = dp1;
            dp1 = Math.max(dp1, nums[i] + dp2);
            dp2 = temp;
        }
        return dp1;
    }
}
