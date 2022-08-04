package zlj.leetcode.hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zlj
 * @date: 2022-08-02  13: 54 :56
 * @des:
 */
public class TwoSum1 {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[]{-1,-1};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (map.get(target - nums[i]) != null) {
                ans[0] = map.get(target - nums[i]);
                ans[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return ans;
    }
}
