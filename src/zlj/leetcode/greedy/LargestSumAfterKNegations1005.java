package zlj.leetcode.greedy;

import org.junit.Test;
import java.util.Arrays;

/**
 * @author zlj
 * @create 2022-06-28-17:41
 */
public class LargestSumAfterKNegations1005 {
    @Test
    public void test(){
        int[] nums = {-4,-2,-3};
        System.out.println(largestSumAfterKNegations(nums, 4));
    }
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        if (nums[0] >= 0){
            nums[0] = (int) (nums[0] * Math.pow(-1, k));
        }else {
            int i;
            for (i = 0; i < k && i < len && nums[i] < 0; i++){
                nums[i] = -nums[i];
            }
            if (i == len){
                nums[i-1] *= Math.pow(-1, (k - i));
            }else {
                int index = nums[i] >= nums[i-1]? i-1 : i;
                nums[index] *= Math.pow(-1, (k - i));
            }
        }
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
        }
        return sum;
    }

    public int largestSumAfterKNegations1(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++){
            if (nums[i] < 0 && k > 0){
                nums[i] = -nums[i];
                k--;
            }
            sum += nums[i];
        }
        Arrays.sort(nums);

        return k % 2 == 0? sum : sum - 2*nums[0];
    }
}
