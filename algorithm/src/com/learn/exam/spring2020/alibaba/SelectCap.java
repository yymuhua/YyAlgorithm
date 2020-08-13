package com.learn.exam.spring2020.alibaba;

import java.util.Scanner;

/**
 * 选队长
 * 1、从n个人中选择任意数量的人员组成一支队伍，然后从一支队伍中选出一位队长，不同的队长算不同的组合，问这样的组合的数量对10^9+7取模 。
 * 数据范围：1 <= n <= 1000000000;
 * 求通项 -> 找规律
 *
 * @author yymuhua
 * @create 2020-04-13 14:24
 */
public class SelectCap {
    public static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner cs = new Scanner(System.in);
        int n = cs.nextInt();
        System.out.println((pow(2, n - 1) * n) % MOD);
    }

    private static long pow(int x, int n) {
        long res = 1;
        while (n > 0) {
            if (n % 2 != 0) res *= x;
            x *= x;
            n /= 2;
        }
        return res;
    }
}
