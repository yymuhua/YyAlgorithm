package com.learn.algorithm.dfs.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * 排列和组合的区别在于：
 *  排列是
 *      for(int i = 0; i < N; i++) { if(!track[i]) {todo...} }
 *  组合
 *      for(int i = start; i < N; i++) { todo... }
 * LeetCode 39. 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * @author yymuhua
 * @create 2020-08-18 10:21
 */
public class Comb1 {
    private int[] A;
    private int N;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if ((A = candidates) == null || (N = A.length) == 0) {
            return new ArrayList<>();
        }
        return dfs(0, target);
    }
    private List<List<Integer>> dfs(int index, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (index >= N) {
            return res;
        }
        for (int cnt = 0; cnt <= target / A[index]; cnt++) {
            int newTarget = target - cnt * A[index];
            List<Integer> base = getRepeatedList(A[index], cnt);
            if (newTarget == 0) {
                res.add(base);
            } else {
                List<List<Integer>> lists = dfs(index + 1, newTarget);
                for (List<Integer> list : lists) {
                    list.addAll(base);
                    res.add(list);
                }
            }
        }
        return res;
    }
    private List<Integer> getRepeatedList(int val, int cnt) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            list.add(val);
        }
        return list;
    }
}