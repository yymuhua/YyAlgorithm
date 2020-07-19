package com.learn.algorithm.ojexam.webank.t2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < t; i++) {
            String s = sc.nextLine();
            int[] cnts = new int[26];
            for (int j = 0; j < s.length(); j++) {
                cnts[(int) s.charAt(j) - 'a']++;
            }
            int cntOrd = 0; // 奇数个数
            for (int c : cnts) {
                if (c % 2 != 0) cntOrd++;
            }
            System.out.println(canWin(cnts, cntOrd) ? "Cassidy" : "Eleanore");
        }
        sc.close();
    }

    public static boolean canWin(int[] cnts, int cntOrd) {
        if (cntOrd <= 1) return true;
        // 回文字符串仅允许有一个字符的数量为奇数
        int sum = 0;
        for (int cnt : cnts) {
            sum += cnt;
        }
        return sum % 2 == 0 ? false : true;
    }
}