package zlj.leetcode.array;


import org.junit.Test;

import java.util.Arrays;

/**
 * @author: zlj
 * @date: 2022-07-26  16: 02 :12
 * @des:
 */
public class RemoveElement27 {
    public int removeElement1(int[] nums, int val) {
        int len = nums.length;
        int afterLen = 0;
        int i = 0;
        while (i < len && nums[i] != val){
            i++;
            afterLen++;
        }
        while (i < len){

            while (i < len && nums[i] == val){
                i++;
            }
            while (i < len && nums[i] != val){
                nums[afterLen++] = nums[i++];
            }
        }
        return afterLen;
    }

    /**
     * 快慢指针
     * @param nums
     * @param val
     * @return
     */
    public int removeElement2(int[] nums, int val) {
        int fast ;
        int slow = 0;
        for (fast = 0; fast < nums.length; fast++){
            if (nums[fast] != val){
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }

    /**
     * 双向指针,交换
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            while (left <= right && nums[left] != val){
                left++;
            }
            while (left <= right && nums[right] == val){
                right--;
            }
            if(left <= right){
                nums[left++] = nums[right--];
            }
        }
        return left;
    }
    @Test
    public void test(){
        int[] nums = {3,2,2,3};
        System.out.println(removeElement(nums, 3));
        System.out.println(Arrays.toString(nums));

        int[] nums1 = {0,1,2,2,3,0,4,2};
        System.out.println(removeElement(nums1, 2));
        System.out.println(Arrays.toString(nums1));
    }

}
