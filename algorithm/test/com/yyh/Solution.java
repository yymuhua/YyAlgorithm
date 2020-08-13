package com.yyh;

import com.learn.algorithm.*;

import java.util.*;

/**
 * @author yeyuhua
 * @version 1.0
 * @created 2020/7/24 12:37 上午
 */
class Solution {
    boolean[] learnable;
    public boolean canFinish(int numCourses, int[][] A) {
        int N;
        if (A == null || (N = A.length) <= 1) {
            return true;
        }
        learnable = new boolean[numCourses];
        // 保存课程的所有前置课程
        Map<Integer, List<Integer>> preMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (preMap.containsKey(A[i][0])) {
                preMap.get(A[i][0]).add(A[i][1]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(A[i][1]);
                preMap.put(A[i][0], list);
            }
        }
        for (Integer course : preMap.keySet()) {
            if (!learnable[course] && circled(course, preMap, new HashSet<>())) {
                return false;
            }
        }
        return true;
    }
    private boolean circled(Integer root, Map<Integer, List<Integer>> preMap, Set<Integer> set) {
        if (set.contains(root)) {
            return true;
        }
        // 判断当前这门课能否修完
        if (preMap.keySet().contains(root)) {
            set.add(root);
            for (Integer course : preMap.get(root)) {
                if (circled(course, preMap, set)) {
                    return true;
                }
            }
            set.remove(root);
        }
        learnable[root] = true;
        return false;
    }
}