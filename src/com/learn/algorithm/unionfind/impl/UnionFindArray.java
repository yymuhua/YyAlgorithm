package com.learn.algorithm.unionfind.impl;


import com.learn.algorithm.unionfind.UnionFind;

/**
 * 并查集：数组表示
 * @author yymuhua
 * @create 2020-04-06 17:41
 */
public class UnionFindArray implements UnionFind {
    // 父亲节点数组
    private int[] partent;
    // size[i] 表示以 i 为树根的树中的节点数
    private int[] size;
    // 连通分量数量
    private int count;

    public UnionFindArray(int n) {
        n = n <= 0 ? 0 : n;
        count = n;
        partent = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++) {
            partent[i] = i;
            size[i] = 1;
        }
    }

    /**
     * 连接两个节点
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ) return ;
        // 小的树拼接到大的树上
        if(size[rootP] < size[rootQ]) {
            partent[rootP] = rootQ;
            size[rootQ] += size[rootP];
            size[rootP] = 0;
        }else {
            partent[rootQ] = rootP;
            size[rootP] += size[rootQ];
            size[rootQ] = 0;
        }
        count--;
    }
    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }
    /**
     * 查找节点所在树的树根
     * @param p
     * @return
     */
    public int find(int p) {
        while(partent[p] != p) {
            // 路径压缩
            partent[p] = partent[partent[p]];
            p = partent[p];
        }
        return p;
    }
    public int count() {
        return count;
    }
}
