package com.learn.exam.autumn2020.meituan.t4;

/**
 * @author yymuhua
 * @create 2020-08-15 16:33
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
        }
        int res1 = 0;
        Arrays.sort(nums, (x, y) -> y[0] - x[0]);
        for (int i = 0; i < a; i++) {
            res1 += nums[i][0];
        }
        int[][] temp = Arrays.copyOfRange(nums, a, n);
        Arrays.sort(temp, (x, y) -> y[1] - x[1]);
        for (int i = 0; i < b; i++) {
            res1 += temp[i][1];
        }
        int res2 = 0;
        Arrays.sort(nums, (x, y) -> y[1] - x[1]);
        for (int i = 0; i < b; i++) {
            res2 += nums[i][1];
        }
        int[][] temp1 = Arrays.copyOfRange(nums, b, n);
        Arrays.sort(temp1, (x, y) -> y[0] - x[0]);
        for (int i = 0; i < a; i++) {
            res2 += temp1[i][1];
        }
        System.out.println(Math.max(res1, res2));
        sc.close();
    }
}
