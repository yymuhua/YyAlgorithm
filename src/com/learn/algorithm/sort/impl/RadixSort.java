package com.learn.algorithm.sort.impl;

import com.learn.algorithm.sort.Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 基数排序：相当于按各位数的排序。
 *          第一轮排完是按各位的升序、第二轮在第一轮的基础上按十位的升序。
 *          以此类推，直到最高位排序完毕，全部均按序排列
 * @author yymuhua
 * @create 2020-03-12 22:10
 */
public class RadixSort implements Sort {
    @Override
    public int[] sort(int[] nums) {
        if(nums == null || nums.length <= 1)
            return nums;
        int N = nums.length;
        // 1 获取数组的最大值和最小值，最大值用于计算最大位数，最小值用于处理负数
        int maxDigit = 0;
        int maxNum = nums[0];
        int minNum = 0; // 用于处理负数的情况
        for(int num : nums) {
            maxNum = Math.max(maxNum, num);
            minNum = Math.min(minNum, num);
        }
        // 将全部数变为非负数
        for(int i = 0; i < N; i++) {
            nums[i] -= minNum;
        }
        maxNum -= minNum;
        // 2 计算最大位数
        while(maxNum != 0) {
            maxDigit++;
            maxNum /= 10;
        }
        // 2 按对应位上的数字进行排序 从 0 到 maxDigit
        List<List<Integer>> bucketList = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            List<Integer> bucket = new ArrayList<>();
            bucketList.add(bucket);
        }
        for(int digit = 0; digit < maxDigit; digit++) {
            int base = (int) Math.pow(10, digit);
            // 2.1 每个数按照第 digit 位的数字放入对应桶中
            for(int i = 0; i < N; i++) {
                int num = (nums[i] / base) % 10;
                bucketList.get(num).add(nums[i]);
            }
            // 2.2 每个数从桶中依次取出
            int index = 0;
            for(int i = 0; i < bucketList.size(); i++) {
                List<Integer> list = bucketList.get(i);
                for(int num : list) {
                    nums[index] = num;
                    index++;
                }
                list.clear();
            }
        }
        for(int i = 0; i < N; i++) {
            nums[i] += minNum;
        }
        return nums;
    }
}
