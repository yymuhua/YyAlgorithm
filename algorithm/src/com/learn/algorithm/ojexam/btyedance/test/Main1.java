package com.learn.algorithm.ojexam.btyedance.test;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Product p = new Product();
        for (int i = 0; i < n; i++) {
            int operator = sc.nextInt();
            int L = sc.nextInt();
            if (operator == 1) {
                p.add(L);
            } else {
                p.remove(L);
            }
            System.out.println(p.productable() ? "Yes" : "No");
        }
        sc.close();
    }
}

class Product {
    Queue<Integer> queue;
    int maxL;
    long sumL;

    public Product() {
        queue = new PriorityQueue<>();
        maxL = 0;
        sumL = 0;
    }

    public boolean productable() {
        if (queue.size() < 3 && sumL < 3) return false;
        for (int i = 3; maxL * i <= sumL; i++) {
            if (sumL % i == 0) {
                if (helper(i)) return true;
            }
        }
        return false;
    }

    // 判断能否将queue中的全部元素等分为N份
    private boolean helper(int N) {
        return false;
    }

    public void add(int L) {
        maxL = Math.max(maxL, L);
        sumL += L;
        queue.add(L);
    }

    public void remove(int L) {
        queue.remove(L);
    }
}