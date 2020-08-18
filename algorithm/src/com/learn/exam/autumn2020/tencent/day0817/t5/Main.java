package com.learn.exam.autumn2020.tencent.day0817.t5;

/**
 * @author yymuhua
 * @create 2020-08-17 16:54
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int L = sc.nextInt();
        int[][] eyes = new int[n][2];
        for (int i = 0; i < n; i++) {
            eyes[i][0] = sc.nextInt();
            eyes[i][1] = sc.nextInt();
        }
        Arrays.sort(eyes, Comparator.comparingInt(a -> a[0]));
        System.out.println(helper(eyes, n, L));
        sc.close();
    }

    private static int helper(int[][] nums, int n, int L) {
        if (nums[0][0] > 0) {
            return -1;
        }
        int xEnd = nums[0][1];
        int index = 0;
        int cnt = 1;
        while (nums[index][0] == 0) {
            xEnd = Math.max(xEnd, nums[index][1]);
            index++;
        }
        while (index < n) {
            if (xEnd >= L) {
                break ;
            }
            // 找到与xEnd相交的结束位置最远的守卫
            int newXEnd = xEnd;
            while (index < n && nums[index][0] <= xEnd) {
                newXEnd = Math.max(nums[index][1], newXEnd);
                index++;
            }
            xEnd = newXEnd;
            cnt++;
        }
        return xEnd >= L ? cnt : -1;
    }
}
