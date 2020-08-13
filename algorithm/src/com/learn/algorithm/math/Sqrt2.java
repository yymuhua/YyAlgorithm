package com.learn.algorithm.math;

/**
 * 计算根号2
 * 采用牛顿迭代法
 * x(n + 1) = x(n) + f(xn) / f'(xn);
 *
 * @author yymuhua
 * @create 2020-04-16 17:32
 */
public class Sqrt2 {
    // 精度要求
    public static final double e = 0.00001;

    public static double sqrt(int n) {
        double res = n >= 1 ? n : 1;
        while (Math.abs(res * res - n) > e) {
            res = 0.5 * (res + n / res);
        }
        return res;
    }
}
