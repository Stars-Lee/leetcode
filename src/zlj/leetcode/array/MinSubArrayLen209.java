package zlj.leetcode.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: zlj
 * @date: 2022-07-28  09: 51 :16
 * @des:
 * 给定一个含有n个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 *
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 *
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *
 * 提示：
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 *  
 *
 * 进阶：
 * 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
 */
public class MinSubArrayLen209 {
    /**
     * 双指针 滑动窗口
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen1(int target, int[] nums) {
        int minLen = nums.length + 1;
        int sum = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length){
            sum += nums[right];
            while (sum >= target){
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }

            right++;
        }
        if (minLen > nums.length){
            return 0;
        }
        return minLen;
    }

    /**
     * 前缀+二分查找
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        if (len == 0){
            return 0;
        }
        int minLen = Integer.MAX_VALUE;
        int[] sums = new int[len + 1];
        for (int i = 1; i <= len; i++){
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= len; i++){
            int s = target + sums[i - 1];
            int bound = Arrays.binarySearch(sums, s);
            if (bound < 0){
                bound = -bound - 1;
            }
            if (bound <= len){
                minLen = Math.min(minLen, bound - (i - 1));
            }
        }
        return minLen == Integer.MAX_VALUE? 0 : minLen;
    }

    @Test
    public void test(){
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, nums));

        int[] nums1 = {1,4,4};
        System.out.println(minSubArrayLen(4, nums1));

        int[] nums2 = {1,1,1,1,1,1,1,1};
        System.out.println(minSubArrayLen(11, nums2));
    }
}
