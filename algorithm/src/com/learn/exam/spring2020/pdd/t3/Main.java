package com.learn.exam.spring2020.pdd.t3;

import java.util.Scanner;

/**
 * @author yymuhua
 * @create 2020-05-06 14:22
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int A, B, N;
        //                      0  1  2  3  4  5  6  7
        int[] nums = new int[]{1, 1, 2, 0, 2, 2, 1, 0};
        for (int n = 0; n < T; n++) {
            A = sc.nextInt() % 3;
            B = sc.nextInt() % 3;
            N = sc.nextInt() % 8;
            int bias = getBias(A, B);
            if (bias == -1) {
                System.out.println("YES");
            } else {
                // N index对应关系为N = 0->index = bias
                int num = nums[(N + bias) % 8];
                System.out.println(num == 0 ? "YES" : "NO");
            }
        }
    }

    public static int getBias(int A, int B) {
        if (A == 0) {
            switch (B) {
                case 1:
                    return 7;
                case 2:
                    return 3;
                default:
                    return -1;
            }
        } else if (A == 1) {
            switch (B) {
                case 0:
                    return 6;
                case 1:
                    return 0;
                case 2:
                    return 1;
                default:
                    return -1;
            }
        } else if (A == 2) {
            switch (B) {
                case 0:
                    return 2;
                case 1:
                    return 5;
                case 2:
                    return 4;
                default:
                    return -1;
            }
        } else return -1;
    }
}
