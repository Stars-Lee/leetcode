package zlj.leetcode.dp;

import java.util.stream.Collectors;

/**
 * @author zlj
 * @create 2022-07-12-14:50
 */
public class CanPartition416 {
    //一维回滚数组,倒序遍历
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 1){
            return false;
        }
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++){
            sum += nums[i];
        }
        if (sum % 2 == 1){
            return false;
        }
        int volume = sum / 2;
        int[] dp = new int[volume+1];
        for (int i = 0; i < len; i++){
            for (int j = volume; j >= nums[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[volume] == volume;
    }

    //二位数组版
    public boolean canPartition1(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1){
            return false;
        }
        int target = sum / 2;
        int[][] dp = new int[len][target + 1];
        for (int j = nums[0]; j <= target; j++){
            dp[0][j] = nums[0];
        }
        //遍历物品，遍历背包
        //递推公式:
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                //背包容量可以容纳nums[i]
                if (j >= nums[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[len - 1][target] == target;
    }

    //二位数组版
    public boolean canPartition2(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1){
            return false;
        }
        int target = sum / 2;
        //dp[i][j]=true 装入i容量刚好为j
        boolean[][] dp = new boolean[len][target+1];
        if (nums[0] <= target){
            dp[0][nums[0]] = true;
        }
        for (int i= 1; i < len; i++){
            for (int j = 0; j <= target; j++){
                dp[i][j] = dp[i-1][j];
                if (nums[i] == j){
                    dp[i][j] = true;
                    continue;
                }

                if (nums[i] < j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[len-1][target];
    }
}
