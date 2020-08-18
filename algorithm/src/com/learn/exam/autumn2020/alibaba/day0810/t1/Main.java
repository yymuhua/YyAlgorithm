package com.learn.exam.autumn2020.alibaba.day0810.t1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给一个长度为 N 的数组代表一个线段上的 N 个点，nums[i] 代表点 i 的坐标
 * 求一个坐标 x ，使得其到这N个点的坐标之和最小
 * @author yymuhua
 * @create 2020-08-16 15:37
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        // 从小到大排序
        Arrays.sort(nums);
        // 取中位数下标
        int mid = nums[(N - 1) / 2];
        long res = 0;
        for (int i = 0; i < N; i++) {
            res += Math.abs(nums[i] - nums[mid]);
        }
        System.out.println(res);
        sc.close();
    }
}
