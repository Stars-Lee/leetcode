package zlj.leetcode.hashTable;

import zlj.leetcode.greedy.MaxProfit;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author: zlj
 * @date: 2022-08-02  14: 09 :13
 * @des:
 */
public class FourSumCount454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum;
        int res = 0;
        for (int i : nums1) {
            for (int j : nums2) {
                sum = i + j;
                Integer count = map.getOrDefault(sum, 0);
                map.put(sum, count + 1);

            }
        }
        for (int i : nums3) {
            for (int j : nums4) {
                sum = i + j;
                Integer count = map.getOrDefault(0 - sum, 0);
                res += count;
            }
        }
        return res;
    }
}
