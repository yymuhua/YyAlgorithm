package com.learn.algorithm.slidwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 各种子串问题
 *
 * @author yymuhua
 * @create 2020-03-14 14:42
 */
public class SubString {
    public static void main(String[] args) {
        SubString subString = new SubString();
        System.out.println(subString.minWindow("A", "A"));
    }

    /**
     * 最短覆盖子串
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";
        if (t.length() == 0) return "";
        // 采用滑动窗口方法获得候选子串
        // 采用两个哈希表计数判定子串中是否完全覆盖 t
        int left = 0;
        int right = 0;
        Map<Character, Integer> windowMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        String res = s;
        // 初始化哈希表
        for (int i = 0; i < t.length(); i++) {
            char thisChar = t.charAt(i);
            windowMap.put(thisChar, 0);
            if (tMap.containsKey(thisChar)) {
                tMap.put(thisChar, tMap.get(thisChar) + 1);
            } else tMap.put(thisChar, 1);
        }
        // 初始化窗口，确保 left 与 right 都从有效字符出发
        while (!tMap.containsKey(s.charAt(left))) left++;
        right = left;
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            // 判断 rightChar 是否属于 t ，
            if (windowMap.containsKey(rightChar)) {
                windowMap.put(rightChar, windowMap.get(rightChar) + 1);
                // 判断当前窗口是否覆盖 t
                while (cover(windowMap, tMap)) {
                    String subStr = s.substring(left, right + 1);
                    res = subStr.length() < res.length() ? subStr : res;

                    char leftChar = s.charAt(left);
                    windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                    left++;
                    while (!tMap.containsKey(s.charAt(left))) left++;
                }
            }
            right++;
        }
        return res;
    }

    // 判断mapA 是否覆盖 mapB
    private boolean cover(Map<Character, Integer> mapA, Map<Character, Integer> mapB) {
        for (Character c : mapA.keySet()) {
            int aValue = mapA.get(c);
            int bValue = mapB.get(c);
            if (aValue < bValue) return false;
        }
        return true;
    }
}
