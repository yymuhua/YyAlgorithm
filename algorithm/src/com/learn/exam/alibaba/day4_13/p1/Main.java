package com.learn.exam.alibaba.day4_13.p1;
/**
 * @author yymuhua
 * @create 2020-03-16 21:50
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n + 1];
        // map 用于保存 key 号小动物和它的崇拜们
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            A[i] = sc.nextInt();
            if (!map.containsKey(A[i])) {
                map.put(A[i], new ArrayList<>());
            }
            List<Integer> list = map.get(A[i]);
            list.add(i);
        }
        for (int i = 1; i <= n; i++) {
            System.out.println(1 + dfs(map, i));
        }
        sc.close();
    }

    // 返回小动物 i 的粉丝数量
    private static long dfs(Map<Integer, List<Integer>> map, int i) {
        if (!map.containsKey(i)) return 0; // 没有被人崇拜
        List<Integer> list = map.get(i);
        long res = 0;
        for (Integer a : list) {
            res += 1 + dfs(map, a); // a + a的粉丝数量
        }
        return res;
    }
}
