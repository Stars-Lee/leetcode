package zlj.leetcode.array.binarySearch;


import javax.swing.*;
import java.lang.annotation.Target;

/**
 * @author: zlj
 * @date: 2022-07-25  19: 06 :05
 * @des:
 */
public class SearchRange34 {
    public int[] searchRange(int[] nums, int target) {
        int leftBorder = searchLeftBorder(nums, target);
        int rightBorder = searchRightBorder(nums, target);
        if (rightBorder == -2 || leftBorder == -2){
            return new int[]{-1, -1};
        }
        if (rightBorder - leftBorder > 1){
            return new int[]{leftBorder + 1, rightBorder - 1};
        }
        return new int[]{-1, -1};
    }
    public int searchRightBorder(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int rightBorder = -2;
        while (low <= high){
            int mid = low + ((high - low) >> 1);
            if (nums[mid] > target){  //最后一次出现的位置一定不不是 >= mid的地方
                high = mid - 1;
            }else {
                low = mid + 1;
                rightBorder = low;
            }
        }
        return rightBorder;
    }
    public int searchLeftBorder(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int rightBorder = -2;
        while (low <= high){
            int mid = low + ((high - low) >> 1);
            if (nums[mid] < target){
                low = mid + 1;
            }else {
                high = mid - 1;
                rightBorder = high;
            }
        }
        return rightBorder;
    }
}
