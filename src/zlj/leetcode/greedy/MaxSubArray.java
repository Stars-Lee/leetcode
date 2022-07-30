package zlj.leetcode.greedy;

import java.security.PublicKey;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *  
 *
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解
 *
 *
 * @author zlj
 * @create 2022-06-24-10:53
 */
public class MaxSubArray {

    //局部最优，当前数组的和小于0， 立即放弃，重新计算数组和
    public int maxSubArray(int[] nums) {
        int result = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum = sum + nums[i];
            result = Math.max(sum, result);
            if (sum < 0){
                sum = 0;
            }
        }
        return result;
    }


    //动态规划，当前的最大数组和取值是否加上前面数组的最大和
    public int maxSubArray1(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        int result = nums[0];
        int maxI = nums[0];//当前位置的最大数组和
        for (int i = 1; i < nums.length; i++){
            maxI = Math.max(nums[i] + maxI, nums[i]);
            result = Math.max(result, maxI);
        }
        return result;
    }
}
