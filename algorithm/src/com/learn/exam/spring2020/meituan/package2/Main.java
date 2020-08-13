package com.learn.exam.spring2020.meituan.package2; /**
 * @author yymuhua
 * @create 2020-03-16 21:50
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String a = "!ddd?dfa'dff,sfsf;sdfa.".replaceAll("!|\\?|\'|,|;|\\.", "");
        "aa".toLowerCase();
        Scanner sc = new Scanner(System.in);
        // define input value
        while (sc.hasNextInt()) {
            // get test value
            int n = sc.nextInt();
            int[] A = new int[3];
            int[] B = new int[3];
            // 获取 A 的最大三张牌
            getMaxThree(sc, A, n);
            // 获取 B 的最大三张票
            getMaxThree(sc, B, n);
            // to do
            long Amax = A[0] + A[1] + A[2];
            long Bmax = B[0] + B[1] + B[2];
            // output
            System.out.println(Math.max(Amax, Bmax));
        }
        sc.close();
    }

    public static void getMaxThree(Scanner sc, int[] A, int n) {
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            // 将num插入到A数组中
            if (num >= A[2]) {
                A[0] = A[1];
                A[1] = A[2];
                A[2] = num;
            } else if (num >= A[1]) {
                A[0] = A[1];
                A[1] = num;
            } else if (num >= A[0]) {
                A[0] = num;
            }
        }
    }

}
