package com.learn.algorithm.ojexam.webank.t3; /**
 * @author yymuhua
 * @create 2020-03-16 21:50
 */
// 第一个行一个数n,代表卡片的数量。 接下来n行，
// 每行用两个数ai,bi描述一张卡片。ai表示抽这张卡能获得的钱数，bi表示抽这张卡能获得的额外抽卡次数。

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
        }
        Arrays.sort(nums, (a, b) -> {
            if (b[1] - a[1] != 0) {
                return b[1] - a[1];
            } else {
                return b[0] - a[0];
            }
        });
        int cnt = 1;
        int sum = 0;
        for (int[] num : nums) {
            cnt += num[1] - 1;
            if (cnt < 0) break;
            sum += num[0];
        }
        System.out.println(sum);
        sc.close();
    }
}
