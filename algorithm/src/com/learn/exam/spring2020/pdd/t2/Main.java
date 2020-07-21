package com.learn.exam.spring2020.pdd.t2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author yymuhua
 * @create 2020-05-06 14:08
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int N;
        for (int n = 0; n < T; n++) {
            N = sc.nextInt();
            int[] L = new int[N];
            int sum = 0;
            for (int i = 0; i < N; i++) {
                L[i] = sc.nextInt();
                sum += L[i];
            }
            // 将L分为四组，每组之和相等
            Arrays.sort(L);
            int target = sum / 4;
            if (sum % 4 != 0 || L[N - 1] > target) {
                System.out.println("NO");
                continue;
            }
            if (candivide2(L, target * 2)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }

    // 判断数组能否分为相等的两组
    public static boolean candivide2(int[] W, int C) {
        if (W == null || W.length == 0)
            return false;
        int N = W.length;
        // 考虑到状态转移方程中dp[i]只与dp[i-1]相关，因此可以省去这一个维度
        // ！！前提，更新dp[i]的时候dp[i - 1]一定不能更新（确保它还是上一行），因此需要反着遍历
        int[] dp = new int[C + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = C; j >= W[i - 1]; j--) {
                // 情况1：不装 W[i - 1]
                // 情况2：装 W[i - 1]，前提是容量足够
                dp[j] = Math.max(dp[j], W[i - 1] + dp[j - W[i - 1]]);
            }
        }
        return dp[C] == C;
    }
}
