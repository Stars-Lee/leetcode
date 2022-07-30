package zlj.leetcode.array;

import com.sun.org.apache.xerces.internal.impl.dv.dtd.NMTOKENDatatypeValidator;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.junit.Test;

import java.lang.annotation.Target;
import java.util.Arrays;

/**
 * @author: zlj
 * @date: 2022-07-27  09: 43 :18
 * @des:
 */
public class RemoveDuplicates26 {
    /**
     * 快慢指针,双重遍历
     * @param nums
     * @return
     */
    public int removeDuplicates1(int[] nums) {
        int slow = 1;
        int fast;
        for (fast = 1; fast < nums.length; fast++){
            int i= 0;
            while (i < slow && nums[i] != nums[fast]){
                i++;
            }
            if(i == slow){
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }

    /**
     * 快慢指针+二分查找
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums){
        int slow = 1;
        int fast;
        for (fast = 1; fast < nums.length; fast++){
            if (!isExist(nums, nums[fast], 0, slow - 1)){
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }

    /**
     * 二分查找
     */
    public boolean isExist(int[] nums, int target, int start, int end){
        int left = start;
        int right = end;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return true;
            }else if (nums[mid] > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return false;
    }

    /**
     * 双指针 + 有序
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums){
        if (nums.length == 0){
            return 0;
        }
        int slow = 0;
        int fast = 1;
//        while (fast < nums.length){
//            nums[slow] = nums[fast];
//            while (fast < nums.length && nums[fast] == nums[slow]){
//                fast++;
//            }
//            slow++;
//        }
        //优化
        while (fast < nums.length){
            if (nums[fast] != nums[slow]){
                nums[++slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }

    @Test
    public void test(){
        int[] nums = {1,1,2};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

        int[] nums1 = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums1));
        System.out.println(Arrays.toString(nums1));

    }
}
