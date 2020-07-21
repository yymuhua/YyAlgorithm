package com.learn.exam.spring2020.meituan.package1; /**
 * @author yymuhua
 * @create 2020-03-16 21:50
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // define input value
        while (sc.hasNextInt()) {
            // get test value
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            int res = 0;
            int pre = nums[0];
            for (int i = 1; i < nums.length - 1; i++) {
                if (nums[i] >= pre && nums[i] >= nums[i + 1]) {
                    res = Math.max(res, helper(nums, i));
                }
                pre = nums[i];
            }
            // to do

            // output
            System.out.println(res);
        }
        sc.close();
    }

    public static int helper(int[] nums, int e) {
        int pre = nums[0];
        int res = 1;
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (i != e) {
                if (nums[i] <= pre) {
                    res = Math.max(res, cnt);
                    cnt = 1;
                } else cnt++;
                pre = nums[i];
            }
        }
        return Math.max(res, cnt);
    }
}