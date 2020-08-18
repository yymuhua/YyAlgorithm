package com.learn.exam.autumn2020.meituan.t3;

/**
 * @author yymuhua
 * @create 2020-08-15 15:53
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        UnionFindArray unionFind = new UnionFindArray(n);
        for (int i = 0; i < m; i++) {
            unionFind.union(sc.nextInt() - 1, sc.nextInt() - 1);
        }
        System.out.println(unionFind.count);
        // 遍历
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (unionFind.size[i] > 0) {
                map.put(i, new ArrayList<>());
            }
        }
        for (int i = 0; i < n; i++) {
            int root = unionFind.find(i);
            map.get(root).add(i);
        }
        List<List<Integer>> lists = new ArrayList<>();
        for (Integer key : map.keySet()) {
            map.get(key).sort(Comparator.comparingInt(a -> a));
            lists.add(map.get(key));
        }
        lists.sort(Comparator.comparingInt(a -> a.get(0)));
        lists.forEach(list -> {
            list.forEach(num -> System.out.print(num + 1 + " "));
        });
        sc.close();
    }
}
class UnionFindArray {
    // 父亲节点数组
    public int[] partent;
    // size[i] 表示以 i 为树根的树中的节点数
    public int[] size;
    // 连通分量数量
    public int count;

    public UnionFindArray(int n) {
        n = n <= 0 ? 0 : n;
        count = n;
        partent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            partent[i] = i;
            size[i] = 1;
        }
    }

    /**
     * 连接两个节点
     */
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        // 小的树拼接到大的树上
        if (size[rootP] < size[rootQ]) {
            partent[rootP] = rootQ;
            size[rootQ] += size[rootP];
            size[rootP] = 0;
        } else {
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
     */
    public int find(int p) {
        while (partent[p] != p) {
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
