package com.learn.exam.autumn2020.pdd.t3;

/**
 * @author yeyuhua
 * @version 1.0
 * @created 2020/8/2 7:23 下午
 */
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int T = sc.nextInt();
        int[][] noon = new int[N][2];
        int[][] dinner = new int[M][2];
        int res = T == 0 ? 0 : Integer.MAX_VALUE;
        int noonMax = noon[0][1];
        for (int i = 0; i < N; i++) {
            noon[i][0] = sc.nextInt();
            noon[i][1] = sc.nextInt();
            if (noon[i][1] >= T) {
                res = Math.min(res, noon[i][0]);
            }
            noonMax = Math.max(noonMax, noon[i][1]);
        }
        int dinnerMax = dinner[0][1];
        for (int i = 0; i < M; i++) {
            dinner[i][0] = sc.nextInt();
            dinner[i][1] = sc.nextInt();
            if (dinner[i][1] >= T) {
                res = Math.min(res, dinner[i][0]);
            }
            dinnerMax = Math.max(dinnerMax, dinner[i][1]);
        }
        if (noonMax + dinnerMax < T) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < N; i++) {
                if (noon[i][1] >= T) {
                    continue ;
                }
                for (int j = 0; j < M; j++) {
                    if (noon[i][1] + dinner[j][1] >= T) {
                        res = Math.min(res, noon[i][0] + dinner[j][0]);
                    }
                }
            }
            System.out.println(res == Integer.MAX_VALUE ? -1 : res);
        }
        sc.close();
    }
}