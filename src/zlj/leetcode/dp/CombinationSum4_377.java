package zlj.leetcode.dp;

import jdk.nashorn.internal.ir.debug.JSONWriter;
import org.junit.Test;

/**
 * @author zlj
 * @create 2022-07-14-10:42
 */
public class CombinationSum4_377 {
    //dp+滚动数组
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int j = 1; j <= target; j++){
            for (int i = 0; i < nums.length; i++){
                if (j >= nums[i]){
                    dp[j] += dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }

    @Test
    public void test(){
        int[] nums = {1,2,3};
        System.out.println(combinationSum4(nums, 4));

        int[] nums1 = {9};
        System.out.println(combinationSum4(nums1, 3));
    }
}
