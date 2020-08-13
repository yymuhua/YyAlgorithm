package com.learn.algorithm.sort.test;

import com.learn.algorithm.sort.Sort;
import com.learn.algorithm.sort.impl.*;

/**
 * @author yeyuhua
 * @version 1.0
 * @created 2020/7/31 2:52 下午
 */
public class Test1 {
    public static void main(String[] args) {
        Sort sort = new QuickSort();
        sort.sort(new int[] {25, 84, 21 ,47, 15, 27, 68, 35, 20});
    }
}
