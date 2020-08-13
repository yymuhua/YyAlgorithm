package com.yyh;

import com.learn.algorithm.*;

import java.util.*;

/**
 * @author yeyuhua
 * @version 1.0
 * @created 2020/7/24 12:37 上午
 */
class Solution {
    public String convert(String s, int numRows) {
        int N;
        if (s == null || (N = s.length()) == 0 || numRows <= 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int period = (numRows - 1) * 2;
        // 按层写入
        for (int i = 0; i < numRows; i++) {
            int start = i;
            while (start < N) {
                sb.append(s.charAt(start));
                int mid = start + period - 2 * (start % period);
                if (mid < N && mid != start && mid != start + period) {
                    sb.append(s.charAt(mid));
                }
                start += period;
            }
        }
        return sb.toString();
    }
}