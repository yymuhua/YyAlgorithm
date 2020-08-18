package com.learn.algorithm.dfs.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * @author yymuhua
 * @create 2020-08-18 11:10
 */
public class Comb3 {
    private int n;
    private int k;
    private boolean[] track;
    public List<List<Integer>> combine(int n, int k) {
        track = new boolean[n + 1];
        this.n = n;
        this.k = k;
        return dfs(0, 1, track);
    }
    private List<List<Integer>> dfs(int level, int index, boolean[] track) {
        List<List<Integer>> res = new ArrayList<>();
        if (level >= k) {
            return res;
        }
        for (int i = index; i <= n; i++) {
            if (!track[i]) {
                // 1. 选择
                track[i] = true;
                // 2. 进入下一层
                List<List<Integer>> lists = dfs(level + 1, i + 1, track);
                // 是否为最后一层
                if (level == k - 1) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    res.add(list);
                } else {
                    for (List<Integer> list : lists) {
                        list.add(i);
                        res.add(list);
                    }
                }
                // 3. 取消选择
                track[i] = false;
            }
        }
        return res;
    }
}
