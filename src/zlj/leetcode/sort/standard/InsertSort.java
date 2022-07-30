package zlj.leetcode.sort.standard;


/**
 * 直接插入排序
 *    整个区间被分为  有序区间  无序区间   每次选择无序区间的第一个元素，在有序区间内选择合适的位置插入
 *
 * * 插入排序和选择排序最大的区别：
 *      当插入排序当前遍历的元素>前驱元素时，此时可以提前结束内层循环
 * * 极端情况，当集合是一个完全有序的集合时，插入排序内层循环一次都不走，插入排序为O(n) 插入排序是许多高阶排序算法的优化基础
 *
 *  * 时间复杂度 n^2
 *  *     最坏 n^2
 *  *     最好 n
 *  * 空间复杂度 1
 *
 *  * 稳定性 : 稳定
 *
 * 折半插入排序:
 *     在有序区间用二分法选择数据应该插入的位置时，因为区间的有序性，可以利用折半查找的思想
 *
 * @author zlj
 * @create 2022-07-15-15:49
 */
public class InsertSort {
    //直接插入
    public int[] insertSort(int[] nums){
        for (int i = 1; i < nums.length; i++){
            for (int j = i; j > 0; j--){
                if (nums[j] >= nums[j - 1]){
                    break;
                }else {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
        return nums;
    }

    //折半插入排序, 二分查找
    public int[] insertSortBS(int[] nums){
        for (int i = 1; i < nums.length; i++){
            int target = nums[i];
            int left = 0;
            int right = i;
            while (left < right){
                int mid = (left + right) / 2;
                if (nums[mid] > target){
                    right = mid;
                }else {
                    left = mid + 1;
                }
            }

            for (int j = i; j > left; j--){
                nums[j] = nums[j - 1];
            }
            nums[left] = target;
        }
        return nums;
    }
}
