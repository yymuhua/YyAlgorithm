package com.learn.algorithm.ojexam.alibaba;

import java.util.*;

/**
 * 定义上升字符串：按字典序升序排列的字符串
 * 给定n个上升字符串，选择任意个拼接起来，问能拼接出来的最长上升字符串长度
 * 动态规划求解
 *
 * @author yymuhua
 * @create 2020-04-13 13:48
 */
public class Day3_20_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = sc.nextLine();
        }
        //按照尾字母升序排列；如果相同则按照首字母从小到大排序
        Arrays.sort(strs, (a, b) -> {
            if (a.charAt(a.length() - 1) == b.charAt(b.length() - 1))
                return a.charAt(0) - b.charAt(0);
            return a.charAt(a.length() - 1) - b.charAt(b.length() - 1);
        });
        int dp[] = new int[26]; // dp[i] 表示以 i + 'a' 字符结尾的最长拼接字符串长度
        int res = 0;
        for (String str : strs) {
            int head = str.charAt(0) - 'a';
            int tail = str.charAt(str.length() - 1) - 'a';
            int maxPrefix = 0;
            // 到字符串 headChar 前面搜索最长的拼接长度，可以拼接在 str 前面
            for (int j = 0; j <= head; j++) {
                maxPrefix = Math.max(maxPrefix, dp[j]);
            }
            dp[tail] = maxPrefix + str.length();
            res = Math.max(res, dp[tail]);
        }
        System.out.println(res);
        sc.close();
    }
}
