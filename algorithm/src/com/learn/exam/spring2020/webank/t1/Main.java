package com.learn.exam.spring2020.webank.t1;

import java.util.*;

//第一行输入四个整数n,m,a,b（1≤n,m,a,b≤100）。
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int maxJ = n - m % n;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= maxJ; j++) {
                if ((m + j) % (n - i) == 0) {
                    res = Math.min(res, a * i + b * j);
                }
            }
        }
        System.out.println(res);
        sc.close();
    }
}