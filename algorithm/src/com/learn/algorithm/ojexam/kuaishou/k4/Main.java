package com.learn.algorithm.ojexam.kuaishou.k4; /**
 * @author yymuhua
 * @create 2020-03-16 21:50
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // define input value
        String[] nmab = sc.nextLine().split(" ");
        int n = Integer.parseInt(nmab[0]);
        int m = Integer.parseInt(nmab[1]);
        int a = Integer.parseInt(nmab[2]);
        int b = Integer.parseInt(nmab[3]);
        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] thisLine = sc.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                nums[i][j] = Integer.parseInt(thisLine[j]);
            }
        }
        List<long[]> res = new ArrayList<>();
        Set<Integer> locs = new HashSet<>();
        int k = (n / a) * (m / b); // 最多能放下的芯片数量
        for (int i = 0; i < k; i++) {
            long[] thisChip = new long[3];
            long minCost = Long.MAX_VALUE;
            int location = 0;
            for (int x = 0; x < n - a; x++) {
                OUT:
                for (int y = 0; y < m - b; y++) {
                    int thisLoc = x * m + y;
                    for (Integer loc : locs) {
                        if (isReact(loc, thisLoc, m, a, b)) break OUT;
                    }
                    long cost = cal(nums, thisLoc, m, a, b);
                    if (cost < minCost) {
                        minCost = cost;
                        location = thisLoc;
                    }
                }

            }
            if (minCost < Long.MAX_VALUE) {
                locs.add(location);
                thisChip[0] = location / m + 1;
                thisChip[1] = location % m + 1;
                thisChip[1] = minCost;
                res.add(thisChip);
                clear(nums, location, m, a, b);
            }
        }

        System.out.println(res.size());
        for (long[] r : res) {
            System.out.println(r[0] + " " + r[1] + " " + r[2]);
        }
        sc.close();
    }

    // 判断两个区域是否相交
    public static boolean isReact(int location1, int location2, int m, int a, int b) {
        int x1 = location1 / m;
        int y1 = location1 % m;
        int x2 = location2 / m;
        int y2 = location2 % m;
        // 上下分离关系
        if (x1 + a <= x2 || x2 + a <= x1) return false;
        // 左右分离关系
        if (y1 + b <= y2 || y2 + b <= y1) return false;
        return true;
    }

    // 返回区域最小能量
    public static int minP(int[][] nums, int location, int m, int a, int b) {
        int x = location / m;
        int y = location % m;
        int min = nums[x][y];
        for (int i = x; i < x + a; i++) {
            for (int j = y; j < y + b; j++) {
                min = Math.min(min, nums[i][j]);
            }
        }
        return min;
    }

    // 返回代价
    public static long cal(int[][] nums, int location, int m, int a, int b) {
        int x = location / m;
        int y = location % m;
        int min = minP(nums, location, m, a, b);
        long res = 0;
        for (int i = x; i < x + a; i++) {
            for (int j = y; j < y + b; j++) {
                res += (long) nums[i][j] - min;
            }
        }
        return res;
    }

    // 清除能量，放入芯片
    public static void clear(int[][] nums, int location, int m, int a, int b) {
        int x = location / m;
        int y = location % m;
        int min = minP(nums, location, m, a, b);
        for (int i = x; i < x + a; i++) {
            for (int j = y; j < y + b; j++) {
                nums[i][j] = min;
            }
        }
    }
}
