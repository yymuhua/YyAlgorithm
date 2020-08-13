package com.learn.exam.autumn2020.wangyi.t3; /**
 * @author yymuhua
 * @create 2020-03-16 21:50
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            int sum = 0;
            for (int j = 0; j < n; j++) {
                nums[j] = sc.nextInt();
                sum += nums[j];
            }
            for (int j = 0; j < n; j++) {
                if ((sum - nums[i]) % 2 == 0) {
                    System.out.println(nums[i]);
                }
            }
        }
        sc.close();
    }
    public static int maxWeight(int[] W, int C) {
        if (W == null || W.length == 0) {
            return 0;
        }
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
