package com.learn.algorithm.math;

/**
 * 求最大公约数
 *
 * @author yymuhua
 * @create 2020-05-06 15:48
 */
public class GCD {
    public static int getGcd(int n, int m) {
        while (m != 0) {
            int temp = n % m;
            n = m;
            m = temp;
        }
        return n;
    }
}
