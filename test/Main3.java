import com.learn.algorithm.sort.SortUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yymuhua
 * @create 2020-04-16 9:26
 */
public class Main3 {
    public static void main(String[] args) {
        List<int[]> res = new ArrayList<>();
        res.toArray(new int[res.size()][]);
    }
    public static int[] sort(int[] nums) {
        int N;
        if(nums == null || (N = nums.length) <= 1) return nums;
        buildHeap(nums);
        while(N > 0) {
            SortUtils.swap(nums, 0, N - 1);
            N--;
            adjustHeap(nums, 0, N);
        }
        return nums;
    }
    public static void buildHeap(int[] nums) {
        int N = nums.length;
        for(int i = N / 2 - 1; i >= 0; i--) {
            adjustHeap(nums, i, N);
        }
    }
    public static void adjustHeap(int[] nums, int start, int end) {
        int maxium = start;
        int left = start * 2 + 1;  // start 的左子节点
        int right = start * 2 + 2; // start 的右子节点
        if(left < end && nums[left] < nums[maxium]) {
            maxium = left;
        }
        if(right < end && nums[right] < nums[maxium]) {
            maxium = right;
        }
        if(maxium != start) {
            SortUtils.swap(nums, start, maxium);
            adjustHeap(nums, maxium, end);
        }

    }
}
