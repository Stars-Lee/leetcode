package zlj.leetcode.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: zlj
 * @date: 2022-07-27  10: 42 :42
 * @des:
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 *
 * 输入: nums = [0]
 * 输出: [0]
 *  
 *
 * 提示:
 *
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *  
 *
 * 进阶：你能尽量减少完成的操作次数吗？
 */
public class MoveZeroes283 {

    /**
     * 双指针
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums.length <= 1){
            return;
        }

        int slow = 0;
        int fast = 0;
        while (fast < nums.length){
            if (nums[fast] != 0){
                if (slow != fast){
                    nums[slow] = nums[fast];
                }
                slow++;
            }
            fast++;
        }
        while (slow < nums.length){
            nums[slow++] = 0;
        }
        return;
    }

    @Test
    public void test(){
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

        int[] nums1 = {0};
        moveZeroes(nums1);
        System.out.println(Arrays.toString(nums1));
    }
}
