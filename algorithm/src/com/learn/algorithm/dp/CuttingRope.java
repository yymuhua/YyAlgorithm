package com.learn.algorithm.dp;

import java.util.ArrayList;

/**
 * 剪绳子
 * @author yeyuhua
 * @version 1.0
 * @created 2020/7/24 12:31 下午
 */
public class CuttingRope {
    /**
     * 剑指 Offer 14- I. 剪绳子
     * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
     * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
     * @param n > 0
     * @return
     */
    public int cuttingRope(int n) {
        // dp[i] 代表长度为i的绳子最大乘积
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            // 剪下一段长度为 j
            for (int j = 1; j <= i / 2; j++) {
                // 剩余部分不剪 j * (i - j)
                // 剩余部分剪 j * dp[i - j]
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
