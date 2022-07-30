package zlj.leetcode.sort.standard;

import org.junit.Test;

import java.util.Arrays;

/**
 *
 * 希尔排序也是一种插入排序，它是简单插入排序经过改进之后的一个更高效的版本,也称为缩小增量排序。
 * 希尔排序也是一种插入排序算法，只不过在插入排序上突破了结界，达到了另一种顶峰的存在，这种顶峰使得时间复杂度变成「O(nLogn)~O(n^2)」.
 * 希尔排序法的基本思想是：
 *     先选定一个整数gap(gap一般为数组长度的一半或1/3)，把待排序数组以gap为间隔分成个组，个组之间内部使用插入排序，排序之后，再将gap/=2或gap/=3，重复上述流程，直到gap=1，此时数组已经近乎有序，利用插入排序对近乎有序的数组进行调整。
 *
 *
 *  * 时间复杂度 O(n^(1.3-2))
 *  *     最坏 n^2
 *  *     最好 1
 *  * 空间复杂度 1
 *
 *  * 稳定性 : 不稳定
 *
 * @author zlj
 * @create 2022-07-15-18:28
 */
public class ShellSort {
    public int[] shellSort(int[] nums) {

        // 希尔排序
        // ap,gap一般为数组长度的一半或1/3,将待排序的数组先按照gap分组，不同组之间内部使用插入排序，排序之后，再将gap/=2或gap/=3，重复上述流程，直到gap=1，此时数组已经近乎有序，利用插入排序对近乎有序的数组进行调整。
        int increment = nums.length >> 1;
        while (increment > 1) {
            insertSortByIncrement(nums, increment);
            increment = increment >> 1;
        }
        insertSortByIncrement(nums, 1);
        return nums;
    }

    //以increment 为间隔, 组内进行插入排序
    public void insertSortByIncrement(int[] nums, int increment){
        for (int i= increment; i < nums.length; i++){
            for (int j = i; j - increment >= 0; j = j - increment){
                if (nums[j] >= nums[j - increment]){
                    break;
                }else {
                    swap(nums, j, j - increment);
                }
            }
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void test(){
        int[] arr = {2, 1, 4, 6, 3, 7, 9, 0};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr1 = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        shellSort(arr1);

        System.out.println(Arrays.toString(arr1));
    }
}
