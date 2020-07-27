package com.learn.algorithm.dp;

/**
 * 0-1背包问题
 *
 * @author yymuhua
 * @create 2020-03-27 10:53
 */
public class Backpack01 {
    public static void main(String[] args) {

    }

    /**
     * 有N块石头，重量分别为W[i]，一个背包（重量）容量为C，求背包的最重重量
     *
     * @param W
     * @return
     */
    public static int maxWeight(int[] W, int C) {
        if (W == null || W.length == 0)
            return 0;
        int N = W.length;
        // 定义 dp[i][j] 表示容量为 j 的背包，装前 i 个石头背包的最重重量
        int[][] dp = new int[N + 1][C + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= C; j++) {
                // 情况1：不装 W[i - 1]
                dp[i][j] = dp[i - 1][j];
                // 情况2：装 W[i - 1]，前提是容量足够
                if (j >= W[i - 1]) {
                    dp[i][j] = Math.max(dp[i][j], W[i - 1] + dp[i - 1][j - W[i - 1]]);
                }
            }
        }
        return dp[N][C];
    }

    /**
     * 空间优化
     *
     * @param W
     * @return
     */
    public static int maxWeight1(int[] W, int C) {
        if (W == null || W.length == 0)
            return 0;
        int N = W.length;
        // 考虑到状态转移方程中dp[i][j]只与dp[i-1][j]相关，因此可以省去i这一个维度
        // ！！前提，更新dp[i][j]的时候dp[i - 1][j]一定不能更新（确保它还是上一行），因此需要反着遍历
        int[] dp = new int[C + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = C; j >= W[i - 1]; j--) {
                // 情况1：不装 W[i - 1]
                // 情况2：装 W[i - 1]，前提是容量足够
                dp[j] = Math.max(dp[j], W[i - 1] + dp[j - W[i - 1]]);
            }
        }
        return dp[C];
    }
}
