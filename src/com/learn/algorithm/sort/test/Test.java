package com.learn.algorithm.sort.test;

import com.learn.algorithm.sort.Sort;
import com.learn.algorithm.sort.impl.*;

import java.util.Arrays;

/**
 * @author yymuhua
 * @create 2020-03-12 18:44
 */
public class Test {
    public static Sort sort;
    static {
//        sort = new BubbleSort();
//        sort = new SelectSort();
//        sort = new InsertSort();
//        sort = new ShellSort();
//        sort = new QuickSort();
//        sort = new MergeSort();
//        sort = new RadixSort();
        sort = new HeapSort();
    }

    public static void main(String[] args) {
        int len = (int) (Math.random() * 100);
        int[] numa1 = new int[len];
        int[] numa2 = new int[len];

        for(int i = 0; i < len; i++) {
            numa1[i] = -1000 + (int) (Math.random() * 2000);
            numa2[i] = numa1[i];
        }
        int[] resa = sort.sort(numa1);
        System.out.println(Arrays.toString(resa));
        Arrays.sort(numa2);
        System.out.println(Arrays.compare(resa, numa2));
    }
}
