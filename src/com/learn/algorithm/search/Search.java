package com.learn.algorithm.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yymuhua
 * @create 2020-03-14 16:25
 */
public class Search {
    public static void main(String[] args) {

    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int N = arr.length;
        int closest = 0;
        // 二分查找找到与 x 最接近的数的索引 closest
        int left = 0;
        int right = N - 1;
        while(left < right) {
            closest = left + (right - left) / 2;
            if(arr[closest] <= x && arr[closest + 1] >= x) {
                if(arr[closest + 1] - x < x - arr[closest]) closest++;
                break;
            }
            else if(arr[closest] > x) right = closest;
            else left = closest + 1;
        }
        // 再从 closest 向两边扩展获得最接近的 k 个数
        left = closest;
        right = closest;
        while(right - left + 1 < k) {
            if(left == 0) right++;
            else if(right == N - 1) left--;
            else if(x - arr[left] <= arr[right] - x) left--;
            else right++;
        }
        // right - left == k
        List<Integer> res = new ArrayList<>();
        for(int i = left; i <= right; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
