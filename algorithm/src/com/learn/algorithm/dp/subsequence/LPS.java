package com.learn.algorithm.dp.subsequence;

/**
 * 最长回文子序列
 *
 * @author yymuhua
 * @create 2020-03-27 15:29
 */
public class LPS {
    public static void main(String[] args) {

    }

    public static int longestPalindromeSubseq(String s) {
        // 定义数组 dp[i][j] 含义为从索引 i 到索引 j 的子串的最长回文子序列
        // 状态转移关系：如果dp[i + 1][j - 1] 为 a：
        //                  当s.charAt(i) == s.charAt(j)时dp[i][j] = a + 2;
        //                  不等时，dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1])
        // base case i = j return 1
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        int[][] dp = new int[n][n];
        // 遍历的顺序需要确保dp[i + 1][j] , dp[i + 1][j - 1] 和dp[i][j - 1]在dp[i][j] 之前计算完毕
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) dp[i][j] = 1;
                else if (s.charAt(i) == s.charAt(j)) dp[i][j] = 2 + dp[i + 1][j - 1];
                else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
