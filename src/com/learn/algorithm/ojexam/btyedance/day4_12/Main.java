package com.learn.algorithm.ojexam.btyedance.day4_12;
/**
 * @author yymuhua
 * @create 2020-03-16 21:50
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int j = 0; j < n; j++) {
                a[j] = sc.nextInt();
            }
            int[] res = new int[n];
            for(int j = 0; j < n; j++) {
                int cnt = 0;
                for(int k = j - 1; k >= 0; k--) {
                    if(a[k] <= a[j]) cnt++;
                    else break;
                }
                for(int k = j + 1; k < n; k++) {
                    if(a[k] <= a[j]) cnt++;
                    else break;
                }
                res[j] = cnt;
            }
            for(int j = 0; j < n; j++) {
                System.out.print(res[j]);
                if(j != n - 1) System.out.print(" ");
                else System.out.println();
            }
        }
    }
}
