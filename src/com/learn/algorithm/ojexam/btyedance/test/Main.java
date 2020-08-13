package com.learn.algorithm.ojexam.btyedance.test; /**
 * @author yymuhua
 * @create 2020-03-16 21:50
 */

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] strs = new String[n];
        long[] score = new long[10]; // 用于存放每一个字符的得分 = 字符所在位数：个位+1，十位+10...
        Set<Character> head = new HashSet<>();
        for(int i = 0; i < n; i++) {
            String str = sc.nextLine();
            strs[i] = str;
            long bit = 1L;
            head.add(str.charAt(0)); // 记录作为字符串首的字符集合
            for(int j = str.length() - 1; j >= 0; j--) {
                score[str.charAt(j) - 'A'] += bit;
                bit *= 10L;
            }
        }
        List<Character> dict = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            dict.add((char) ('A' + i));
        }
        Collections.sort(dict, (c1, c2) -> {
            if(score[c1 - 'A'] - score[c2 - 'A'] < 0L) {
                return -1;
            }else if(score[c1 - 'A'] - score[c2 - 'A'] > 0L) {
                return 1;
            }
            return 0;
        });
        // 如果 dict 开头的字符在集合 head 内，需要调整其位置
        int i = 0;
        // 先找到一个优先级最低的可以作为 0 的字符
        while(head.contains(dict.get(i))) {
            i++;
        }
        // 将其冒泡到开头
        while(i > 0) {
            swap(dict, i, i - 1);
        }
        long res = 0L;
        for(String str : strs) {
            res += parse(dict, str);
        }
        System.out.println(res);
    }
    private static void swap(List<Character> dict, int a, int b) {
        char temp = dict.get(a);
        dict.add(a, dict.get(b));
        dict.add(b, temp);
    }
    public static long parse(List<Character> dict, String s) {
        long res = 0L;
        long product = 1L;
        for(int j = s.length() - 1; j >= 0; j--) {
            res += dict.indexOf(s.charAt(j)) * product;
            product *= 10L;
        }
        return res;
    }
}