package com.learn.algorithm.ojexam.kuaishou.k3; /**
 * @author yymuhua
 * @create 2020-03-16 21:50
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(",");
        List<String> list = new ArrayList<>();
        Map<String, Double> scores = new HashMap<>();
        for (String str : strs) {
            double score = score(str);
            scores.put(str, score);
            if (score > 0.1) list.add(str); // 是靓号才加入
        }
        int N;
        if ((N = list.size()) == 0) {
            System.out.println("null");
        } else {
            Collections.sort(list, (s1, s2) -> compare(scores, s2, s1));
            for (int i = 0; i < N; i++) {
                System.out.print(list.get(i));
                if (i != N - 1) System.out.print(",");
            }
        }
        sc.close();
    }

    // N顺子得分为N，N豹子得分为N.5
    private static double score(String s) {
        double res = 0.0;
        int N = s.length();
        int left = 3;
        int right = 4;
        // 判断上升顺子的价值
        while (right < N) {
            if (s.charAt(right) != s.charAt(right - 1) + 1) {
                if (right - left >= 3) {
                    res = Math.max(res, right - left);
                }
                left = right;
            }
            right++;
        }
        // 判断下降顺子的价值
        left = 3;
        right = 4;
        while (right < N) {
            if (s.charAt(right) != s.charAt(right - 1) - 1) {
                if (right - left >= 3) {
                    res = Math.max(res, right - left);
                }
                left = right;
            }
            right++;
        }
        // 判断豹子的价值
        left = 3;
        right = 4;
        while (right < N) {
            if (s.charAt(right) != s.charAt(left)) {
                if (right - left >= 3) {
                    res = Math.max(res, right - left + 0.5);
                }
                left = right;
            }
            right++;
        }
        return res;
    }

    private static int compare(Map<String, Double> map, String s1, String s2) {
        double diff = map.get(s1) - map.get(s2);
        if (diff > 0.2) return 1;
        if (diff < -0.2) return -1;
        return 0;
    }
}
