package zlj.leetcode.hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: zlj
 * @date: 2022/8/2 - 20:38
 * @desc:
 */
public class ThreeSum15 {
    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        //排序 + 双指针
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            //若第一个数大于0 ，则不可能存在三数之和等于0
            if (nums[i] > 0){
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0){
                    right--;
                }else if (sum < 0){
                    left++;
                }else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    right--;
                    left++;
                }
            }
        }
        return result;
    }
}
