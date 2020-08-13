import com.learn.algorithm.sort.Sort;
import com.learn.algorithm.sort.SortUtils;

/**
 * @author yymuhua
 * @create 2020-04-17 22:40
 */
public class InsertSort {
    public static int[] insertSort(int[] nums) {
        int N;
        if(nums == null || (N = nums.length) <= 1) return nums;
        for(int i = 1; i < N; i++) {
            // 每次都将 nums[i] 插入有序数组 nums[0, i - 1] 中
            int currIdx = i;
            while(currIdx >= 0) {
                if(nums[currIdx - 1] > nums[i]) {
                    // 碰到大于 nums[i] 的，后退一格
                    nums[currIdx] = nums[currIdx - 1];
                }else {
                    // 当前位置为小于 nums[i] 的最大值，nums[i] 应该插入到它后面
                    break;
                }
                currIdx--;
            }
            nums[currIdx + 1] = nums[i];
        }
        return nums;
    }
}
