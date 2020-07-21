package com.learn.exam.spring2020.alibaba;

/**
 * @author yymuhua
 * @create 2020-04-11 16:36
 */
public class Day3_27_1 {
    public static void main(String[] args) {
        System.out.println(moveCnt("aab", "baa"));
    }

    /**
     * 将 S 的某个字符移动到末尾计为一次操作，
     * 问从 S 变为 T 最少需要多少次操作
     * 本质：求 S 的最长子序列（子序列为 T 的前缀）
     *
     * @param S
     * @param T
     * @return
     */
    public static int moveCnt(String S, String T) {
        int N = S.length();
        int cnt = 0;
        int idxOfT = 0; // T 中 idxOfT 后面的部分都是移动过来的，前面的部分都是 S 保留的
        // 这意味着保留的部分必须要能为 S 的子序列
        for (int i = 0; i < N; i++) {
            if (S.charAt(i) == T.charAt(idxOfT)) {
                idxOfT++;
            } else {
                cnt++;
            }
        }
        return cnt;
    }

}
