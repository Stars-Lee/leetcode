package zlj.leetcode.dp;

import org.junit.Test;

import java.util.stream.Collectors;

/**
 * @author zlj
 * @create 2022-07-13-11:27
 */
public class FindTargetSumWays494 {
    //dp+二维
    public int findTargetSumWays(int[] nums, int target) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (Math.abs(target) > sum){
            return 0;
        }
        if ((sum + target) % 2 != 0){
            return 0;
        }
        int volume = (sum + target) / 2;
        int[][] dp = new int[len][volume + 1];
        //初始化
        if (nums[0] == 0){
            dp[0][0] = 2;
        }else {
            dp[0][0] = 1;
        }
        for (int j = 1; j <= volume; j++){
            if (j == nums[0]){
                dp[0][j] = 1;
            }else {
                dp[0][j] = 0;
            }
        }
        for (int i= 1; i < len; i++){
            for (int j = 0; j <= volume; j++){
                if (nums[i] > j){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[len - 1][volume];
    }

    //dp+滚动数组
    public int findTargetSumWays2(int[] nums, int target) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (Math.abs(target) > sum){
            return 0;
        }
        if ((sum + target) % 2 != 0){
            return 0;
        }
        int volume = (sum + target) / 2;
         int[] dp = new int[volume + 1];
         dp[0] = 1;
         for (int i = 0; i < len; i++){
             for (int j = volume; j >= nums[i]; j--){
                 dp[j] = dp[j] + dp[j - nums[i]];
             }
         }
         return dp[volume];
    }
    @Test
    public void test(){
        int[] nums = {0,0,0,0,0,0,0,0,1};
        System.out.println(findTargetSumWays2(nums, 1));
    }
}
