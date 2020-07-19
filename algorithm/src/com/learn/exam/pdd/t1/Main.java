package com.learn.exam.pdd.t1; /**
 * @author yymuhua
 * @create 2020-03-16 21:50
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);
        long res = 0;
        for (int i = 1; i < N; i++) {
            if (A[i] <= A[i - 1]) {
                res += (A[i - 1] + 1 - A[i]);
                A[i] = A[i - 1] + 1;
            }
        }
        System.out.println(res);
        sc.close();
    }
}
