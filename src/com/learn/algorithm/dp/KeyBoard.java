package com.learn.algorithm.dp;

/**
 * 四键键盘：
 * 假设你有一个特殊的键盘包含下面的按键：
 *      Key 1: (A)：在屏幕上打印一个 'A'。
 *      Key 2: (Ctrl-A)：选中整个屏幕。
 *      Key 3: (Ctrl-C)：复制选中区域到缓冲区。
 *      Key 4: (Ctrl-V)：将缓冲区内容输出到上次输入的结束位置，并显示在屏幕上。
 *
 * 现在，你只可以按键 N 次（使用上述四种按键），请问屏幕上最多可以显示几个 'A'呢？
 * @author yymuhua
 * @create 2020-03-28 21:08
 */
public class KeyBoard {
    /**
     *
     * @param N
     * @return
     */
    public static int maxA(int N) {
        // 这个算法基于这样⼀个事实， 最优按键序列⼀定只有两种情况：
        // 要么⼀直按 A ： A,A,...A（当 N ⽐较⼩时） 。
        // 要么是这么⼀个形式： A,A,...C-A,C-C,C-V,C-V,...C-V（当 N ⽐较⼤时） 。
        int[] dp = new int[N + 1]; // dp[i] 表示 i 次操作之后能显示多少 A
        // base case
        dp[0] = 0; // 初始状态
        for(int i = 1; i <= N; i++) {
            dp[i] = 1 + dp[i - 1]; // 情况1：一直按A
            for(int j = 2; j < i; j++) {
                // 情况2：从位置 j 开始粘贴，后面一直粘贴
                dp[i] = Math.max(dp[i], dp[j - 2] * (i - j + 1));
            }
        }
        return dp[N];
    }
}
