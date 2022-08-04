package zlj.leetcode.hashTable;

import java.util.*;

/**
 * @author: zlj
 * @date: 2022/8/1 - 21:56
 * @desc:
 */
public class Intersect350 {
    //hashmap
    public int[] intersect1(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i : nums1) {
            Integer count = map1.getOrDefault(i, 0);
            count = count + 1;
            map1.put(i, count);
        }

        for (int i : nums2) {
            Integer count = map2.getOrDefault(i, 0);
            count = count + 1;
            map2.put(i, count);
        }

        for (Integer i : map1.keySet()) {
            int count1 = map1.get(i);
            int count2 = map2.getOrDefault(i, 0);
            for (int j = 0; j < Math.min(count2, count1); j++){
                list.add(i);
            }
        }
        return list.stream().mapToInt(x -> x).toArray();
    }
    //hashmap优化
    public int[] intersect2(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i : nums1) {
            Integer count = map1.getOrDefault(i, 0) + 1;
            map1.put(i, count);
        }

        for (int i : nums2) {
            Integer count = map1.getOrDefault(i, 0);
            if (count != 0){
                list.add(i);
                map1.put(i, --count);
            }
        }

        return list.stream().mapToInt(x -> x).toArray();
    }
    //排序+双指针
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] ans = new int[Math.min(len2, len1)];
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        while (index1 < len1 && index2 < len2){
            if (nums1[index1] < nums2[index2]){
                index1++;
            }else if (nums1[index1] > nums2[index2]){
                index2++;
            }else {
                ans[index++] = nums1[index1++];
                index2++;
            }
        }
        return Arrays.copyOfRange(ans, 0, index);
    }
}
