package com.learn.algorithm.ojexam.alibaba.day4_13.p2;
/**
 * @author yymuhua
 * @create 2020-03-16 21:50
 */

import java.util.*;

public class Main {
    public static Map<Integer, Integer> memo;
    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        memo = new HashMap<>();
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int l = sc.nextInt();
            int[] nums = new int[]{b, l};
            if (!map.containsKey(a)) {
                List<int[]> list = new ArrayList<>();
                list.add(nums);
                map.put(a, list);
            } else {
                List<int[]> list = map.get(a);
                list.add(nums);
            }
        }
        long res = 0;
        Set<Integer> visited = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            int num1 = dfs(map, visited, i, x);
            int num2 = dfs(map, visited, x, i);
            res = Math.max(res, num1 + num2);
        }
        System.out.println(res);
        sc.close();
    }

    private static int dfs(Map<Integer, List<int[]>> map, Set<Integer> visited, int start, int end) {
        if (start == end) return 0;
        if (memo.containsKey(start * (n + 1) + end)) return memo.get(start * (n + 1) + end);
        int res = Integer.MAX_VALUE;
        visited.add(start);
        List<int[]> neighbors = map.get(start);
        for (int[] neighbor : neighbors) {
            if (!visited.contains(neighbor[0])) {
                int nextLen = dfs(map, visited, neighbor[0], end);
                if (nextLen != Integer.MAX_VALUE) {
                    res = Math.min(res, nextLen + neighbor[1]);
                }
            }
        }
        visited.remove(start);
        if (res != Integer.MAX_VALUE) { // 路径不通？是否需要考虑
            memo.put(start * (n + 1) + end, res);
        }
        return res;
    }
}
