package com.learn.algorithm.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 幂集合
 * @author yymuhua
 * @create 2020-04-13 18:36
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        int N;
        if(nums == null || (N = nums.length) == 0) return new ArrayList<>();
        return helper(nums, 0, N);
    }
    private List<List<Integer>> helper(int[] nums, int start, int end) {
        List<List<Integer>> res = new ArrayList<>();
        if(start >= end) {
            res.add(new ArrayList<>());
            return res;
        }
        List<List<Integer>> lists = helper(nums, start + 1, end);
        for (List<Integer> list : lists) {
            res.add(list);
            List<Integer> newList = new ArrayList<>(list);
            newList.add(nums[start]);
            res.add(newList);
        }
        return res;
    }
}
