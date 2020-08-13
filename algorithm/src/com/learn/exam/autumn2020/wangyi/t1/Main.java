package com.learn.exam.autumn2020.wangyi.t1; /**
 * @author yymuhua
 * @create 2020-03-16 21:50
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += calCnt(sc.nextInt());
        }
        System.out.println(cnt);
        sc.close();
    }
    private static long calCnt(int num) {
        if (num <= 1) {
            return 0;
        }
        return num / 2;
    }
}
