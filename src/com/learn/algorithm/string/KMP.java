package com.learn.algorithm.string;

/**
 * KMP 算法是在 txt 中查找子串 pat，如果存在，返回这个子串的起始索引，否则返回 -1。
 * @author yymuhua
 * @create 2020-03-27 20:55
 */
public class KMP {
    public static void main(String[] args) {
        String txt = "dababc";
        String pat = "ababc";
        System.out.println(txt.indexOf(pat));
        System.out.println(kmpSearch(pat, txt));
    }
    public static int kmpSearch(String pat, String txt) {
        if(pat == null || txt == null) return -1;
        if(pat.equals("")) return 0;

        int M = pat.length();
        int N = txt.length();
        // 获取状态转移数组
        int[][] dp = getDP(pat);
        // 初始态为 0
        int status = 0;
        for (int i = 0; i < N; i++) {
            // 计算 pat 的下⼀个状态
            status = dp[status][txt.charAt(i)];
            // 到达终⽌态， 返回结果
            if (status == M) return i - M + 1;
        }
        // 没到达终⽌态， 匹配失败
        return -1;
    }
    /**
     * 获取状态数组 dp
     * dp[i][c]：i 表示当前已经匹配了多少个字符，
     *           c 表示如果此时遇到字符c应该到哪个状态（即到哪个i）
     * 绝大多数情况下，遇到c不匹配pat.charAt(i)，直接退回 i = 0状态（匹配则 i + 1）
     * 但是如果两个状态具有相同的前缀，如 AB 与 ABAB，那么dp[4]['A']显然不需要退回状态 i = 0
     * 只需要退回状态 i = 3 即可。公共前缀状态就是用来处理这种情况的。
     * 公共前缀状态：
     */
    public static int[][] getDP(String pat) {
        int M = pat.length();
        // dp[状态][字符] = 下个状态
        int[][] dp = new int[M][256];
        // base case
        dp[0][pat.charAt(0)] = 1;
        // 公共前缀状态初始为 0 ，因为状态 i = 0 的公共前缀状态为 0
        int comPrefixStatus = 0;
        // 构建状态转移数组
        for (int status = 1; status < M; status++) {
            for (int c = 0; c < 256; c++) {
                dp[status][c] = dp[comPrefixStatus][c];
            }
            dp[status][pat.charAt(status)] = status + 1;
            // 更新公共前缀状态
            comPrefixStatus = dp[comPrefixStatus][pat.charAt(status)];
        }
        return dp;
    }
}
