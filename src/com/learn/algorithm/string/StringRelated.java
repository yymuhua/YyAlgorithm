package com.learn.algorithm.string;

import java.util.Arrays;

/**
 * @author yymuhua
 * @create 2020-03-15 20:16
 */
public class StringRelated {
    public static void main(String[] args) {
        System.out.println(Arrays.toString("s.".split("\\.")));
//        System.out.println(lengthOfLongestSubstring("bbtablud"));
//        System.out.println("abc".indexOf("a", 2));
    }
    public static int lengthOfLongestSubstring(String s) {
        /*
        int num = 0;
        Set<Character> hashset = new HashSet<>();
        int j=0;
        for(int i=0;i<s.length();i++){
            for(;j<s.length();j++){
                if(!hashset.contains(s.charAt(j))){
                    hashset.add(s.charAt(j));
                    if ((j-i+1)>num) {
                        num = j-i+1;
                    }
                }else {
                    hashset.remove(s.charAt(i));
                    break;
                }
            }
        }
        return num;
        */
        int res = 0;
        int left = 0;
        int right = 0;
        while(right < s.length()){
            char c = s.charAt(right);
            int index = s.indexOf(c, left);
            if(index < 0 || index >= right) {
                right++;
                res = Math.max(res, right - left);
            }else {
                left = index + 1;
                right++;
            }
        }
        return res;
    }
}
