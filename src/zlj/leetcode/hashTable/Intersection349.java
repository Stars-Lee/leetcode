package zlj.leetcode.hashTable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: zlj
 * @date: 2022/8/1 - 21:26
 * @desc:
 */
public class Intersection349 {
    //因为0 <= nums1[i], nums2[i] <= 1000
    //所以我们可以 将数组作为哈希表进行存储， 用set存储结果去重
    public int[] intersection1(int[] nums1, int[] nums2) {
        int[] count = new int[1005];
        for (int i : nums1) {
            count[i] = 1;
        }
        Set<Integer> set = new HashSet<>();
        for (int i : nums2) {
            if (count[i] == 1){
                set.add(i);
            }
        }
        return set.stream().mapToInt(x -> x).toArray();
    }
    //当值很大时 或分散时，可以用set作为哈希表
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> ans = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if (set1.contains(i)){
                ans.add(i);
            }
        }
        return ans.stream().mapToInt(x -> x).toArray();
    }
}
