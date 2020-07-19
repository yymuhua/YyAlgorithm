package com.learn.algorithm.ojexam.pdd.t4;

import java.util.Scanner;

/**
 * @author yymuhua
 * @create 2020-05-06 14:44
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        long res = N;
        for (int i = 0; i < N; i++) {
            int gcd = A[i];
            for (int j = i; j < N; j++) {
                gcd = getGcd(gcd, A[j]);
                long len = j - i + 1;
                res = Math.max(res, gcd * len);
                if (gcd == 1) {
                    break;
                }
            }
        }
        System.out.println(res);
        sc.close();
    }

    public static int getGcd(int n, int m) {
        while (m != 0) {
            int temp = n % m;
            n = m;
            m = temp;
        }
        return n;
    }
}