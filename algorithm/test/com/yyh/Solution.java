package com.yyh;

import com.learn.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author yeyuhua
 * @version 1.0
 * @created 2020/7/24 12:37 上午
 */
public class Solution {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        // dp[i][j] 表示前i个数字被分为j个区间的此问题解
        int[][] dp = new int[n + 1][m + 1];
        // 初值
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, m); j++) {
                int sum = nums[i - 1];
                for (int k = i - 1; k > 0; k--) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], sum));
                    sum += nums[k - 1];
                }
            }
        }
        return dp[n][m];
    }
}
