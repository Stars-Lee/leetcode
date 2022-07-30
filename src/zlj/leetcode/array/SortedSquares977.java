package zlj.leetcode.array;

import javafx.scene.chart.NumberAxis;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author: zlj
 * @date: 2022-07-27  17: 26 :51
 *
 *
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * 示例 2：
 *
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 已按 非递减顺序 排序
 *  
 *
 * 进阶：
 * 请你设计时间复杂度为 O(n) 的算法解决本问题
 */
public class SortedSquares977 {
    //暴力
    public int[] sortedSquares1(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    /**
     * 双指针
     */
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int negative = -1;//负值最后一个index
        for (int i = 0; i < len; i++){
            if (nums[i] < 0){
                negative++;
            }else {
                break;
            }
        }

        int[] res = new int[len];
        int index = 0;
        int i = negative;
        int j = negative + 1;

        while (i >= 0 || j < len){
            if (i < 0){
                res[index] = nums[j] * nums[j];
                j++;
            }else if (j == len){
                res[index] = nums[i] * nums[i];
                i--;
            }else if (nums[i] * nums[i] > nums[j] * nums[j]){
                res[index] = nums[j] * nums[j];
                j++;
            }else {
                res[index] = nums[i] * nums[i];
                i--;
            }
            index++;
        }
        return res;
    }


    @Test
    public void test(){
        int[] nums = {-4,-1,0,3,10};
        System.out.println(Arrays.toString(sortedSquares(nums)));

        int[] nums1 = {-7,-3,2,3,11};
        System.out.println(Arrays.toString(sortedSquares(nums1)));
    }
}
