package com.learn.algorithm.unionfind;

/**
 * @author yymuhua
 * @create 2020-04-06 21:01
 */
public interface UnionFind {
    int find(int p);
    boolean connected(int p, int q);
    void union(int p, int q);
}
