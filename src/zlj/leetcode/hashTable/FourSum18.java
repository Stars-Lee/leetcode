package zlj.leetcode.hashTable;

import org.junit.Test;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: zlj
 * @date: 2022/8/2 - 21:37
 * @desc:
 */
public class FourSum18 {
    @Test
    public void test() {
        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        fourSum(nums, -294967296);
    }
    //排序 + 双指针
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++){
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++){
                if ((j > i + 1) && nums[j] == nums[j - 1]){
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right){
                    long sum2 = (long) nums[i] + nums[j] + nums[left] +nums[right];
                    if (sum2 > target){
                        right--;
                    }else if (sum2 < target){
                        left++;
                    }else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        while (right > left && nums[left] == nums[left + 1]) left++;
                        right--;
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
