package com.learn.algorithm.ojexam.meituan.p3; /**
 * @author yymuhua
 * @create 2020-03-16 21:50
 */
// 第一行三个整数n，k，m。(1≤n≤100),(1≤k≤100),(0≤m≤2e9)
//
// 第二行两个整数p，q。(1≤p,q≤100)
//
// 第三行k个整数表示每个子任务需要的时间。(1≤ ti≤1e6)

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // define input value
        while (sc.hasNextInt()) {
            int kCost = 0;
            int res = 0;
            // get test value
            int n = sc.nextInt();
            int k = sc.nextInt();
            int m = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();
            int[] t = new int[k];
            for (int i = 0; i < k; i++) {
                t[i] = sc.nextInt();
                kCost += t[i];
            }
            // to do
            Arrays.sort(t);
            int taskDone = m / kCost;
            res = taskDone * (p * k + q);
            m %= kCost;
            // 仅剩 n - taskDone 个任务
            OUT:
            for (int j = 0; j < k; j++) {
                for (int i = 0; i < n - taskDone; i++) {
                    if ((m -= t[j]) >= 0) {
                        res += p;
                    } else {
                        break OUT;
                    }
                }
            }
            // output
            System.out.println();
        }
        sc.close();
    }
}
