package com.learn.algorithm.search;

/**
 * 快速幂
 *
 * @author yymuhua
 * @create 2020-04-01 11:20
 */
public class FastPow {
    public static void main(String[] args) {
        System.out.println(pow(11.0, 2));
    }

    /**
     * 快速幂计算
     */
    public static double pow(double x, int n) {
        double res = 1.0;
        while (n != 0) {
            if (n % 2 != 0) {
                res *= x;
            }
            x = x * x;
            n /= 2;
        }
        return res;
    }
}
