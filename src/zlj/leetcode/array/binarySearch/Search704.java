package zlj.leetcode.array.binarySearch;


import org.junit.Test;

/**
 * @author: zlj
 * @date: 2022-07-25  17: 44 :32
 * @des:
 */
public class Search704 {
    //遍历
    public int search1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == target){
                return i;
            }
        }
        return -1;
    }

    //二分查找,左闭右闭
    public int search2(int[] nums, int target){
        //区间
        int l = 0;
        int r = nums.length - 1;
        //中值
        int mid;
        while (l <= r){
            mid = l + (r - l) / 2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right){
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }

    @Test
    public void test(){
        int[] nums = new int[1000];
        String string = new String();
    }

}
