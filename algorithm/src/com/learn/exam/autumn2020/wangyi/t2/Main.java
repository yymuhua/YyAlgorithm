package com.learn.exam.autumn2020.wangyi.t2; /**
 * @author yymuhua
 * @create 2020-03-16 21:50
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer> listM = new ArrayList<>(n);
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            if (i < m) {
                listM.add(sc.nextInt());
            }
            list.add(i + 1);
        }
        list.removeAll(listM);
        // 双指针
        int p1 = 0;
        int p2 = 0;
        int num;
        while (p1 < m && p2 < list.size()) {
            if (listM.get(p1) <= list.get(p2)) {
                num = listM.get(p1);
                p1++;
            } else {
                num = list.get(p2);
                p2++;
            }
            System.out.print(num + " ");
        }
        while (p1 < m) {
            System.out.print(listM.get(p1) + " ");
            p1++;
        }
        while (p2 < m) {
            System.out.print(list.get(p2) + " ");
            p2++;
        }
        sc.close();
    }
}