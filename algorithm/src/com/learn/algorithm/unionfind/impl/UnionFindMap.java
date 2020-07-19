package com.learn.algorithm.unionfind.impl;

import com.learn.algorithm.unionfind.UnionFind;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yymuhua
 * @create 2020-04-06 21:01
 */
public class UnionFindMap implements UnionFind {

    // 父亲节点数组
    private Map<Integer, Integer> parent;

    // size[i] 表示以 i 为树根的树中的节点数
    private Map<Integer, Integer> size;

    // 连通分量数量
    private int count;

    public UnionFindMap(int[] nums) {
        int N = nums.length;
        count = N;
        parent = new HashMap<>(N);
        size = new HashMap<>(N);
        for (int num : nums) {
            parent.put(num, num);
            size.put(num, 1);
        }
    }

    public int find(int p) {
        while (parent.get(p) != p) {
            // 路径压缩
            parent.put(p, parent.get(parent.get(p)));
            p = parent.get(p);
        }
        return p;
    }

    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        if (size.get(rootP) < size.get(rootQ)) {
            parent.put(rootP, rootQ);
            size.put(rootQ, size.get(rootP) + size.get(rootQ));
            size.put(rootP, 0);
        } else {
            parent.put(rootQ, rootP);
            size.put(rootP, size.get(rootP) + size.get(rootQ));
            size.put(rootQ, 0);
        }
        count--;
    }
}
