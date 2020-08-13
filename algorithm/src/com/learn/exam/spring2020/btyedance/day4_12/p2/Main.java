package com.learn.exam.spring2020.btyedance.day4_12.p2;
/**
 * @author yymuhua
 * @create 2020-03-16 21:50
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //折木棒
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(in.nextInt());
        }
        if (n == 1) {
            System.out.println(0);
            return;
        }
        int count = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (list.get(i) > list.get(i + 1)) {
                int count1 = (int) Math.ceil((double) list.get(i) / list.get(i + 1));
                list.set(i, list.get(i) / count1);
                count += count1 - 1;
            }
        }
        System.out.println(count);
    }
}
