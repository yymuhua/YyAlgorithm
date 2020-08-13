package com.learn.algorithm.string;

import java.util.Arrays;

/**
 * 回文子串问题
 *
 * @author yymuhua
 * @create 2020-04-11 11:26
 */
public class EchoString {
    /**
     * LeetCode5. 最长回文子串：给定一个字符串 s，找到 s 中最长的回文子串。
     */
    class Solution0 {
        private char[] charArray;

        public String longestPalindrome(String s) {
            if (s == null || s.length() == 0) return s;
            int resStart = 0; // 结果的初始索引
            int resLen = 0;   // 结果的长度
            charArray = s.toCharArray();
            // 遍历字符串，每次都从遍历到的位置向两边扩散，判断回文子串
            for (int i = 0; i < charArray.length; i++) {
                int newLen = 0;
                // 搜索一charArray[i]为中点的回文子串
                if ((newLen = searchEchoStr(i, i)) > resLen) {
                    resLen = newLen;
                    resStart = i - resLen / 2;
                }
                // 搜索charArray[i] 和 charArray[i + 1]为中心的回文子串
                if ((newLen = searchEchoStr(i, i + 1)) > resLen) {
                    resLen = newLen;
                    resStart = i - resLen / 2;
                }
            }
            return String.valueOf(Arrays.copyOfRange(charArray, resStart, resStart + resLen + 1));
        }

        private int searchEchoStr(int mid1, int mid2) {
            if (mid2 > charArray.length) return 0;
            while (mid1 >= 0 && mid2 < charArray.length &&
                    charArray[mid1] == charArray[mid2]) {
                mid1--;
                mid2++;
            }
            return mid2 - mid1 - 2;
        }
    }

    /**
     * LeetCode131. 分割回文串2：给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
     * 返回符合要求的最少分割次数。
     */
    class Solution1 {
        private String s;
        private int N;
        private int[] dp;
        private boolean[][] echo;

        public int minCut(String s) {
            if (s == null || (N = s.length()) == 0) return 0;
            this.s = s;
            dp = new int[N]; // dp[i] 表示从 i 到字符串末尾的子串最少分割次数 + 1
            echo = new boolean[N][N]; // echo[i][j] 表示从 i 到 j 的子串是否为回文
            for (int i = 0; i < N; i++) {
                // 更新以 i 为中心的子串
                echo[i][i] = true;
                int left = i - 1;
                int right = i + 1;
                while (left >= 0 && right < N) {
                    echo[left][right] = (s.charAt(left) == s.charAt(right)) &&
                            echo[left + 1][right - 1];
                    left--;
                    right++;
                }
                if (i != N - 1) {
                    // 更新以 i 和 i + 1 为双中心的子串
                    echo[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
                    left = i - 1;
                    right = i + 2;
                    while (left >= 0 && right < N) {
                        echo[left][right] = (s.charAt(left) == s.charAt(right)) &&
                                echo[left + 1][right - 1];
                        left--;
                        right++;
                    }
                }
            }
            return dp(0) - 1;
        }

        private int dp(int start) {
            if (start >= N) return 0;
            if (dp[start] != 0) return dp[start];
            int res = Integer.MAX_VALUE;
            for (int i = start; i < N; i++) {
                // 判断从start 到 i 是否为回文
                if (echo[start][i]) {
                    res = Math.min(res, 1 + dp(i + 1));
                    if (res == 1) break;
                }
            }
            dp[start] = res;
            return res;
        }
    }

    /**
     * LeetCode214. 最短回文串：给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。
     * 找到并返回可以用这种方式转换的最短回文串。
     */
    static class Solution2 {
        public String shortestPalindrome(String s) {
            int N;
            if (s == null || (N = s.length()) == 0) return s;
            // 本质为找到最长的前缀回文子串
            int mid = 0;
            for (int i = N - 1; i >= 0; i--) {
                if (s.charAt(mid) == s.charAt(i)) {
                    mid++;
                }
            }
            if (mid == N) {
                // 整个 s 已经是回文串
                return s;
            }
            String prefix = s.substring(0, mid);
            String suffix = s.substring(mid, N);
            return reverse(suffix) + shortestPalindrome(prefix) + suffix;
        }

        private String reverse(String s) {
            StringBuilder sb = new StringBuilder(s);
            sb.reverse();
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.shortestPalindrome("ba");
    }
}
