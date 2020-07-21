package com.learn.exam.spring2020.btyedance.day4_12.p1;
/**
 * @author yymuhua
 * @create 2020-03-16 21:50
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            boolean negtive = false;
            for (int j = 0; j < n; j++) {
                a[j] = sc.nextInt();
            }
            int cnt = 1;
            int diff = 0;
            for (int j = 0; j < n; j++) {
                b[j] = sc.nextInt() - a[j];
                if (!negtive && b[j] < 0) negtive = true;
                if (!negtive && b[j] != diff) {
                    if (cnt == 1) {
                        cnt--;
                        diff = b[j];
                    } else if (b[j] == 0) {
                        diff = 0;
                    } else {
                        negtive = true;
                    }
                }
            }
            if (helper(b, n)) System.out.println("NO");
            else System.out.println("YES");
        }
        sc.close();
    }

    private static boolean helper(int[] b, int n) {
        int cnt = 1;
        int diff = 0;
        for (int j = 0; j < n; j++) {
            if (b[j] < 0) return true;
            if (b[j] != diff) {
                if (cnt == 1) {
                    cnt--;
                    diff = b[j];
                } else if (b[j] == 0) {
                    diff = 0;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
//    private static String helper(int[] b, int n) {
//        boolean res = false;
//        int cnt = 1;
//        boolean inRange = false; //
//        int left = 0;
//        int right = n - 1;
//        while(left < n && b[left] == 0) {
//            left++;
//        }
//        while(right >= 0 && b[right] == 0) {
//            right--;
//        }
//        int diff = 0;
//        if(left < n) {
//            diff = b[left];
//        }
//        if(diff < 0) return "NO";
//        while(left <= right) {
//            if(diff != b[left]) return "NO";
//            left++;
//        }
//        return "YES";
//    }
}
