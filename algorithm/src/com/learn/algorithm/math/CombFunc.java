package com.learn.algorithm.math;

import java.util.Arrays;

/**
 * 组合函数的计算
 *
 * @author yymuhua
 * @create 2020-04-04 17:29
 */
public class CombFunc {
    public static void main(String[] args) {
        Comb(1, 6);
    }

    /**
     * n 件物品中取 k 件的取法总共有多少种
     * 0 <= k <= n
     * 采用杨辉三角进行计算
     * n, k = 0 1 2 3 4
     * -----------------
     * 0  ->  1
     * 1  ->  1 1
     * 2  ->  1 2 1
     * 3  ->  1 3 3 1
     * 4  ->  1 4 6 4 1
     */
    public static int Comb(int k, int n) {
        int[] dp = new int[n + 1]; // dp[j] 代表从 i 件物品取 j 件
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j >= 0; j--) {
                dp[j] = dp[j] + (j > 0 ? dp[j - 1] : 0);
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[k];
    }
}
