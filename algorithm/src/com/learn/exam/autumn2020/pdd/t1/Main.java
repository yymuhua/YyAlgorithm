package com.learn.exam.autumn2020.pdd.t1;

/**
 * @author yeyuhua
 * @version 1.0
 * @created 2020/8/2 6:58 下午
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int N = sc.nextInt();
        // 回退次数
        int cnt = 0;
        boolean isWin = K == 0;
        for (int i = 0; i < N; i++) {
            K -= sc.nextInt();
            if (K == 0 || isWin) {
                isWin = true;
                break ;
            } else if (K < 0) {
                K = -K;
                cnt++;
            }
        }
        System.out.println(isWin ? "paradox" : K + " " + cnt);
        sc.close();
    }
}

