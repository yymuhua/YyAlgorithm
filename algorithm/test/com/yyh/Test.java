package com.yyh;

import com.learn.algorithm.TreeNode;

/**
 * @author yeyuhua
 * @version 1.0
 * @created 2020/7/19 2:19 下午
 */
public class Test {
    public static Solution sol = new Solution();
    public static void main(String[] args) {
        int cnt = 0;
        for (int i = 1000; i < 10000; i++) {
            if (i % 2 == 1 && helper(i + "")) cnt++;
        }
        System.out.println(cnt);
    }
    public static boolean helper(String s) {
        if (s.contains("4") || s.contains("9")) {
            return false;
        }
        int[] cnt = new int[10];
        for (int i = 0; i < 4; i++) {
            if (++cnt[s.charAt(i) - '0'] > 1) {
                return false;
            }
        }
        return true;
    }
}
