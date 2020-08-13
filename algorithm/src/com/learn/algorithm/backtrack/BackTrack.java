package com.learn.algorithm.backtrack;

import java.util.*;

/**
 * 回溯算法
 *
 * @author yymuhua
 * @create 2020-04-07 16:16
 */
public class BackTrack {
    /**
     * LeetCodde46. 全排列：
     * 给定一个没有重复数字的数组，返回所有可能的全排列
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length <= 0) return res;
        Set<Integer> track = new HashSet<>();
        return helper(0, track, nums);
    }

    private List<List<Integer>> helper(int level, Set<Integer> track, int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (level >= nums.length) return res;
        for (int num : nums) {
            if (!track.contains(num)) {
                // 1. 选择
                track.add(num);
                // 2. 进入下一层
                List<List<Integer>> lists = helper(level + 1, track, nums);
                if (lists.size() == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(num);
                    res.add(list);
                } else {
                    for (List<Integer> list : lists) {
                        list.add(num);
                        res.add(list);
                    }
                }
                // 3. 撤销选择
                track.remove(num);
            }
        }
        return res;
    }

    /**
     * LeetCode 47. 全排列2
     * 给定一个包含重复数字的数组，返回所有可能的全排列
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length <= 0) return res;
        boolean[] track = new boolean[nums.length];
        return helper(0, track, nums);
    }

    private List<List<Integer>> helper(int level, boolean[] track, int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (level >= nums.length) return res;
        Set<Integer> used = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!track[i] && !used.contains(num)) {
                used.add(num);
                // 1. 选择
                track[i] = true;
                // 2. 进入下一层
                List<List<Integer>> lists = helper(level + 1, track, nums);
                if (lists.size() == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(num);
                    res.add(list);
                } else {
                    for (List<Integer> list : lists) {
                        list.add(num);
                        res.add(list);
                    }
                }
                // 3. 撤销选择
                track[i] = false;
            }
        }
        return res;
    }

    /**
     * LeetCode 40. 组合总数：给定一个数组 nums 和一个目标数 target ，
     * 找出 nums 中所有可以使数字和为 target 的组合。
     * nums 中的每个数字在每个组合中只能使用一次。
     * 所有数均为正数
     */
    class Solution {
        private int[] A;
        private int N;

        public List<List<Integer>> combinationSum2(int[] nums, int target) {
            if ((A = nums) == null || (N = A.length) == 0) return new ArrayList<>();
            Arrays.sort(A);
            return dfs(target, 0);
        }

        private List<List<Integer>> dfs(int target, int start) {
            List<List<Integer>> res = new ArrayList<>();
            for (int i = start; i < N; i++) {
                if (i != start && A[i] == A[i - 1]) continue; // 去重
                if (A[i] <= target) {
                    if (A[i] == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(target);
                        res.add(list);
                        break;
                    } else {
                        // A[i] < target
                        List<List<Integer>> lists = dfs(target - A[i], i + 1);
                        for (List<Integer> list : lists) {
                            list.add(A[i]);
                            res.add(list);
                        }
                    }
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution s = new BackTrack().new Solution();
        s.combinationSum2(new int[]{1, 1, 2, 2, 5}, 5);
        Arrays.sort(new int[][]{new int[]{1, 2}}, (num1, num2) -> ("" + num1 + num2).compareTo("" + num2 + num1));
    }
}
