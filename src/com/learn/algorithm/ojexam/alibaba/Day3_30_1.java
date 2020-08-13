package com.learn.algorithm.ojexam.alibaba;

import java.util.*;

/**
 * n个鸡场，初始每个有a[i]只鸡，每天增长k只，并且每天最多的那个鸡场，卖一半鸡（向下取整），问m天后共几只鸡。
 * @author yymuhua
 * @create 2020-04-13 16:15
 */
public class Day3_30_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int a[] = new int[n];
        long res = 0;
        List<Integer> list = new LinkedList<>();
        for( int i = 0; i < n; i++ ) {
            a[i] = sc.nextInt();
            list.add(a[i]);
        }
        Collections.sort(list);
        for(int i = 0; i < m; i++) {
            // 每天每个鸡场新增 k 只鸡
            for(int j = 0; j < n; j++) {
                list.set(j, k + list.get(j));
            }
            // 卖掉数量最多的鸡场一半的鸡
            int max = list.get(n - 1);
            int setVal = max / 2;
            int idx = n - 1;
            while(list.get(idx) == max) {
                list.remove(idx);
                insert(list, setVal);
            }
        }
        for(Integer num : list) {
            res += num;
        }
        System.out.println(res);
    }
    // 将数值 val 插入到有序数组 list 中
    private static void insert(List<Integer> list, int val) {
        int N = list.size();
        int i = 0;
        while(i < N && list.get(i) < val) {
            i++;
        }
        if(i == N) list.add(val);
        else list.add(i, val);
    }
}
