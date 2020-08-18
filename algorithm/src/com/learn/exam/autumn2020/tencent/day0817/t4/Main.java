package com.learn.exam.autumn2020.tencent.day0817.t4;

/**
 * 由于业绩优秀，公司给小Q放了 n 天的假，身为工作狂的小Q打算在在假期中工作、锻炼或者休息。
 * 他有个奇怪的习惯：不会连续两天工作或锻炼。只有当公司营业时，小Q才能去工作，
 * 只有当健身房营业时，小Q才能去健身，小Q一天只能干一件事。给出假期中公司，健身房的营业情况，求小Q最少需要休息几天。
 * @author yymuhua
 * @create 2020-08-17 16:31
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] comOpenDay = new int[N];
        int[] gymOpenDay = new int[N];
        for (int i = 0; i < N; i++) {
            comOpenDay[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            gymOpenDay[i] = sc.nextInt();
        }
        // dp[i][j] 代表第i天休息（j = 0）或工作（j = 1）或锻炼（j = 2），前 i 天中休息日的最少天数
        int[][] dp = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            boolean comOpen = comOpenDay[i - 1] == 1;
            boolean gymOpen = gymOpenDay[i - 1] == 1;
            if (comOpen) {
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]);
            } else {
                dp[i][1] = Integer.MAX_VALUE;
            }
            if (gymOpen) {
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]);
            } else {
                dp[i][2] = Integer.MAX_VALUE;
            }
            dp[i][0] = 1 + Math.min(dp[i - 1][0], Math.min(dp[i - 1][1], dp[i - 1][2]));
        }
        System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
        sc.close();
    }
}
