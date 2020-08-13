package com.learn.exam.spring2020.alibaba;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * 小强和小明是很好的朋友，有一天小强在刷题的时候遇到一一个他从来没遇到过的问题，问题是这样描述的:
 * 给你一个长度n数组a,问数组中有多少有价值的数?规定若ax为有价值的数，当且仅当:
 * x左侧存在大于ax的数，右侧存在小于ax的数，论左侧最小的大于ax的数为f，右侧小于ax的最大的数记为g: f为g的倍数。
 * 输入描述:
 * 输入包含两行，第1行仅一个整数n,表示数组的长度接下来一行有n个整数,表示数组a
 * 保证全部数据: 1≤n≤10^5,1≤ai≤10^18
 *
 * @author yymuhua
 * @create 2020-04-13 15:11
 */
public class Day4_3_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] left = new int[n]; // left[i] 代表在 a[i] 左侧大于 a[i] 的最小数
        int[] right = new int[n]; // right[i] 代表在 a[i] 右侧小于 a[i] 的最大数
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            int minUpper = Integer.MAX_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                if (a[j] > a[i] && a[j] < minUpper) {
                    minUpper = a[j];
                }
            }
            left[i] = minUpper;
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            int maxLower = Integer.MIN_VALUE;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[i] && a[j] > maxLower) {
                    maxLower = a[j];
                }
            }
            right[i] = maxLower;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (left[i] != -1 && right[i] != -1 && left[i] % right[i] == 0) {
                res++;
            }
        }
        System.out.println(res);
    }
}
