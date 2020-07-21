package com.learn.exam.spring2020.kuaishou.k2; /**
 * @author yymuhua
 * @create 2020-03-16 21:50
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // define input value
        String[] nums = sc.nextLine().split(" ");
        int N = nums.length;
        int[] max = new int[2];
        boolean hasRes = false;
        Arrays.fill(max, Integer.MIN_VALUE);

        for (int i = 0; i < N; i++) {
            int thisNum = Integer.parseInt(nums[i]);
            if (thisNum >= max[0] && thisNum < max[1]) {
                hasRes = true;
                System.out.print(i);
                if (i != N - 1) System.out.print(" ");
            }
            // 更新 max 数组
            if (thisNum >= max[1]) {
                max[0] = max[1];
                max[1] = thisNum;
            } else if (thisNum >= max[0]) {
                max[0] = thisNum;
            }
        }
        if (!hasRes) System.out.println(-1);
        sc.close();
    }
}
