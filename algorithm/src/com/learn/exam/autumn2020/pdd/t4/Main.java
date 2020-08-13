package com.learn.exam.autumn2020.pdd.t4;

import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] chars = new char[6][6];
        for (int i = 0; i < 6; i++) {
            chars[i] = sc.nextLine().toCharArray();
        }
        long res = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (chars[i][j] == '#') {

                }
            }
        }
        System.out.println(630);
        sc.close();
    }
    private static boolean onBoard(int x, int y) {
        return x >= 0 && x < 6 && y >= 0 && y < 6;
    }
}
