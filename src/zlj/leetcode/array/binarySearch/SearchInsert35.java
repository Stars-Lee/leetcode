package zlj.leetcode.array.binarySearch;


import org.junit.Test;

/**
 * @author: zlj
 * @date: 2022-07-25  18: 27 :21
 * @des:
 */
public class SearchInsert35 {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r){
            int mid = l + ((r - l) >> 1);
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return l;
    }

    @Test
    public void test(){
        int[] nums = {1,3,5,6};
        System.out.println(searchInsert(nums, 5));
        System.out.println(searchInsert(nums, 2));
        System.out.println(searchInsert(nums, 7));
    }
}
