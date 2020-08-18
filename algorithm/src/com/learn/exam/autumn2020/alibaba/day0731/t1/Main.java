package com.learn.exam.autumn2020.alibaba.day0731.t1;

import java.util.*;

/**
 * 小强是一个农场主，农场里有n头牛，每头牛有着独一无二的体重，
 * 每一头牛的颜色可能是mm种颜色其中的一种，小强带了一些牛（可能为00个）出来吃草。你需要回答出小强带出来的牛的组合一共有多少种可能？
 * 推公式 result = ∑(i = 0 -> n) C(i, n) * m ^ i = (m + 1) ^ n
 * @author yymuhua
 * @create 2020-08-16 14:02
 */
public class Main {
    private static final int MOD_BASE = 10_000_000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(quickPow(m + 1, n));
        sc.close();
    }
    private static long quickPow(long x, long n) {
        long res = 1;
        while (n > 0) {
            if (n % 2 != 0) {
                res = (res * x) % MOD_BASE;
            }
            x = (x * x) % MOD_BASE;
            n /= 2;
        }
        return res;
    }
}
