package com.learn.algorithm.dp;

import java.util.Arrays;

/**
 * @author yymuhua
 * @create 2020-08-17 21:24
 */
public class ChangeCoins {
    /**
     * 零钱兑换：给定不同面额的硬币 coins 和一个总金额 amount。
     * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
     */
    public static int coinChange(int[] coins, int amount) {
        if(amount == 0) {
            return 0;
        }
        if(coins == null || coins.length == 0) {
            return -1;
        }
        int[] dp = new int[amount + 1]; // dp[i] 代表 i 金额下所需的最少硬币数
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    /**
     * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
     */
    public static int change(int amount, int[] coins) {
        int N;
        if (amount == 0) {
            return 1;
        }
        if (coins == null || (N = coins.length) == 0 || amount < 0) {
            return 0;
        }
        // dp[i][j] 代表采用前i个硬币，凑齐j元钱的组合数
        int[][] dp = new int[N][amount + 1];
        for (int i = 0; i < N; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j <= amount; j++) {
            dp[0][j] = (j % coins[0]) == 0 ? 1 : 0;
        }
        for (int i = 1; i < N; i++) {
            int coin = coins[i];
            for (int j = 1; j <= amount; j++) {
                // 1、不用coin
                dp[i][j] = dp[i - 1][j];
                // 2、只用coin
                if (j % coin == 0) {
                    dp[i][j]++;
                }
                // 3、都用
                int num = j;
                while (num > coin) {
                    dp[i][j] += dp[i - 1][num - coin];
                    num -= coin;
                }
            }
        }
        return dp[N - 1][amount];
    }

    /**
     * 优化
     */
    public int change1(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(change(5, new int[]{1, 2, 5}));
    }
}
