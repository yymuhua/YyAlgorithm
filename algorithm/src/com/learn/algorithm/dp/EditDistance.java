package com.learn.algorithm.dp;

/**
 * 编辑距离问题
 *
 * @author yymuhua
 * @create 2020-03-27 12:40
 */
public class EditDistance {
    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        System.out.println(minDistance(word1, word2)); // 5
    }

    /**
     * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数。
     * 你可以对一个单词进行如下三种操作：
     * 1. 插入一个字符
     * 2. 删除一个字符
     * 3. 替换一个字符
     *
     * @param word1
     * @param word2
     * @return
     */
    public static int minDistance(String word1, String word2) {
        if (word1 == null || word1.length() == 0)
            return word2 == null ? 0 : word2.length();
        if (word2 == null || word2.length() == 0)
            return word1.length();
        int m = word1.length();
        int n = word2.length();
        // 定义 dp[i][j] 为 word1.substring(0, i), word2.substring(0, j) 的距离
        int[][] dp = new int[m + 1][n + 1];
        // base case
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char charI = word1.charAt(i - 1);
                char charJ = word2.charAt(j - 1);
                if (charI == charJ) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 1. 替换 dp[i][j] = 1 + dp[i - 1][j - 1];
                    // 2. 在word1末尾插入或word2删除 dp[i][j] = 1 + dp[i - 1][j];
                    // 3. 在word2末尾插入或word1删除 dp[i][j] = 1 + dp[i][j - 1];
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1],
                            Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[m][n];
    }
}
