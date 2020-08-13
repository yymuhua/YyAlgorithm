package com.learn.algorithm.dp.subsequence;

/**
 * 最长公共子序列问题
 * @author yymuhua
 * @create 2020-03-27 14:58
 */
public class LCS {
    public static void main(String[] args) {
        String s1 = "abcba";
        String s2 = "acba";
        System.out.println(longestCommonSubsequence(s1, s2));
    }

    /**
     * 返回两个字符串最长公共子序列的长度
     * @param s1
     * @param s2
     * @return
     */
    public static int longestCommonSubsequence(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();
        // dp[i][j] 表示s1.substring(0, i) 与 s2.substring(0, j)的最长公共子序列长度
        int[][] dp = new int[m + 1][n + 1];
        // 1. base case
        // i == 0 时 dp = 0
        // j == 0 时 dp = 0
        // 2. 遍历填充数组
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                char charI = s1.charAt(i - 1);
                char charJ = s2.charAt(j - 1);
                if(charI == charJ) {
                    // 如果相等，显然最长公共子序列需要 + 1
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }else {
                    // 如果不相等，各去掉一个字符再比较，取其大者
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
