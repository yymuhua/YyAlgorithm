package com.learn.algorithm.search;

/**
 * 二分查找
 * @author yymuhua
 * @create 2020-04-01 11:16
 */
public class BinarySearch {
    /**
     * 模板1：搜索升序数组中的目标数
     * 特点：每次访问一个元素 mid
     */
    public static int binarySearch(int[] nums, int target){
        if(nums == null || nums.length == 0)
            return -1;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){ return mid; }
            else if(nums[mid] < target) { left = mid + 1; }
            else { right = mid - 1; }
        }
        // End Condition: left > right
        return -1;
    }

    /**
     * 模板2：搜索1到n个版本中第一个出错的版本（前面的正确，后面的错误，找分界点）
     * 特点：每次访问mid和右邻居
     */
    public static int firstBadVersion(int n) {
        if(n == 0||n == 1) return n;
        int left = 1;
        int right = n;
        while(left < right){
            int mid = left + (right - left) / 2;
            boolean isMidBad = isBadVersion(mid);
            boolean isMid1Bad = isBadVersion(mid + 1);
            if(!isMidBad && isMid1Bad) return mid + 1;
            else if(isMidBad && isMid1Bad) right = mid;
            else left = mid + 1;
        }
        // 结束条件：left == right ，后处理判断是否全是错版本
        if(isBadVersion(left)) return left;
        return -1;
    }
    public static boolean isBadVersion(int i) {return false;}

    /**
     * 模板3：搜索一个数组中的任意一个峰值（大于左右邻居）
     * 特点：访问mid和左右邻居
     */
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        if(nums.length == 1) return 0;
        int left = 0;
        int  right = nums.length - 1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            // 可访问的索引 mid, mid - 1, mid + 1
            if(nums[mid] > nums[mid - 1] &&
                    nums[mid] > nums[mid + 1])
                return mid;
            if(nums[mid] <= nums[mid - 1])
                right = mid;
            else
                left = mid;
        }
        // 结束条件：left + 1 = right
        if(nums[left] > nums[right] && left == 0)
            return left;
        if(nums[right] > nums[left] &&
                right == nums.length - 1)
            return right;
        return -1;
    }

    /**
     * LeetCode33. 搜索一个旋转的排序数组，返回索引（数组中没有重复元素）
     * 如 {4,5,6,7,0,1,2}
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int N;
        if(nums == null || (N = nums.length) == 0) return -1;
        int left = 0;
        int right = N - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] >= nums[left]) { // 前半部分有序
                if(nums[mid] > target && target >= nums[left]) right = mid - 1; // 位于有序部分
                else left = mid + 1;
            }else { // 后半部分有序
                if(nums[mid] < target && target <= nums[right]) left = mid + 1; // 位于有序部分
                else right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * LeetCode81. 搜索一个旋转的排序数组，返回是否存在（数组包含重复元素）
     * 如{1,0,1,1,1}
     * @param nums
     * @param target
     * @return
     */
    public boolean search1(int[] nums, int target) {
        int N;
        if(nums == null || (N = nums.length) == 0) return false;
        int left = 0;
        int right = N - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return true;
            if(nums[left] == nums[mid]) { // 退化为线性搜索
                left++;
                continue;
            }
            if(nums[mid] > nums[left]) { // 前半部分有序
                if(nums[mid] > target && target >= nums[left]) right = mid - 1;
                else left = mid + 1;
            }else { // 后半部分有序
                if(nums[mid] < target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return false;
    }
}
