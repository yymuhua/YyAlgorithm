package com.learn.exam.autumn2020.meituan.t1;

import java.util.Scanner;

public class Main {
    private static StringBuilder stringBuilder;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        stringBuilder = new StringBuilder();
        int cnt = 0;
        for (int i = 1; i <= n / 4; i++) {
            cnt += cntHelper(i) ? 1 : 0;
        }
        System.out.println(cnt);
        if (cnt > 0) {
            System.out.println(stringBuilder.toString());
        }
        sc.close();
    }
    private static boolean cntHelper(int x) {
        StringBuilder sb = new StringBuilder(x + "");
        int reverse = Integer.parseInt(sb.reverse().toString());
        boolean res = reverse == 4 * x;
        if (res) {
            stringBuilder.append(x + " " + reverse + " ");
        }
        return res;
    }
}