package com.learn.exam.spring2020.btyedance.day4_12.p3;
/**
 * @author yymuhua
 * @create 2020-03-16 21:50
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int j = 0; j < m; j++) {
            b[j] = sc.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        long res = 0;
        int start = n - 1;
        for (int i = m - 1; i >= 0; i--) {
            // 找到小于 b[i] 的最大 a[idx]
            int idx = start;
            while (idx >= 0) {
                if (a[idx] <= b[i]) {
                    start = idx;
                    break;
                }
                idx--;
            }
            if (idx >= 0) {
                res += b[i] - a[idx];
            } else {
                res += b[i];
            }
        }
        System.out.println(res);
        sc.close();
    }
}
