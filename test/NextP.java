import com.learn.algorithm.sort.SortUtils;

/**
 * @author yymuhua
 * @create 2020-04-18 10:45
 */
public class NextP {
    public static int[] nextP(int[] nums) {
        int N;
        if(nums == null || (N = nums.length) <= 1) return nums;
        int bound = N - 1; // 分界点，bound - 1前面的部分将保持不变，bound变为更大的数
        while(bound > 0) {
            if(nums[bound] > nums[bound - 1]) {
                // 确定了bound
                // 需要找到下降区间 [bound, N) 内大于 nums[bound - 1] 的最小值
                int idx = bound;
                while(idx < N && nums[idx] > nums[bound - 1]) {
                    idx++;
                }
                idx--;
                SortUtils.swap(nums, idx, bound - 1);
                break;
            }
            bound--;
        }
        // 将下降区间 [bound, N) 转换为上升区间，确保刚好是下一个排列
        int left = bound;
        int right = N - 1;
        while(left < right) {
            SortUtils.swap(nums, left, right);
        }
        return nums;
    }

}
