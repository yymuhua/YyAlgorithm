package com.learn.algorithm.dfs.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 40. 组合总数：给定一个数组 nums 和一个目标数 target ，
 * 找出 nums 中所有可以使数字和为 target 的组合。
 * nums 中的每个数字在每个组合中只能使用一次。
 * 所有数均为正数
 */
public class Comb2 {

    private int[] A;
    private int N;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if ((A = candidates) == null || (N = A.length) == 0) {
            return new ArrayList<>();
        }
        // 方便去重
        Arrays.sort(A);
        return dfs(0, target);
    }
    private List<List<Integer>> dfs(int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (start >= N || target <= 0) {
            return res;
        }
        for (int i = start; i < N && A[i] <= target; i++) {
            int newTarget = target - A[i];
            if (i > start && A[i] == A[i - 1]) {
                continue ;
            }
            if (newTarget == 0) {
                List<Integer> list = new ArrayList<>();
                list.add(A[i]);
                res.add(list);
            } else {
                List<List<Integer>> lists = dfs(i + 1, newTarget);
                for (List<Integer> list : lists) {
                    list.add(A[i]);
                    res.add(list);
                }
            }
        }
        return res;
    }
}
