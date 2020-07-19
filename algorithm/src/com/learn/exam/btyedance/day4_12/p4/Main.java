package com.learn.exam.btyedance.day4_12.p4;
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
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = sc.nextInt();
            }
            int[] left = new int[n]; // 先放房子左边能看到的数量
            int[] right = new int[n];
            Deque<Integer> stack = new ArrayDeque<>();
            // 倒着遍历
            for (int j = n - 1; j >= 0; j--) {
                // 将stack中小于等于当前数的全部出栈
                while (!stack.isEmpty() && a[stack.peek()] <= a[j]) {
                    stack.pop();
                }
                right[j] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(j);
            }
            stack = new ArrayDeque<>();
            for (int j = 0; j < n; j++) {
                // 将stack中小于等于当前数的全部出栈
                while (!stack.isEmpty() && a[stack.peek()] <= a[j]) {
                    stack.pop();
                }
                left[j] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(j);

            }
            for (int j = 0; j < n; j++) {
                int num1 = left[j] == -1 ? j : j - left[j] - 1;
                int num2 = right[j] == -1 ? n - 1 - j : right[j] - j - 1;
                System.out.print(num1 + num2);
                if (j != n - 1) System.out.print(" ");
                else System.out.println();
            }
        }
        sc.close();
    }
}
