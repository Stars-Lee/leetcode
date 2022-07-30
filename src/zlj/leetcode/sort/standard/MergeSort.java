package zlj.leetcode.sort.standard;

import org.junit.Test;

import java.util.Arrays;

/**
 * 归并排序是建立在归并操作上的一种有效的排序算法,该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子
 * 序列段间有序。若将两个有序表合并成一个有序表，称为二路归并。
 * 将原数组不断拆分，一直拆到每个子数组只有一个元素时，第一个阶段结束，归而为1的过程
 *
 *  * 时间复杂度 nlogn
 *  *     最坏 nlogn
 *  *     最好 nlogn
 *  * 空间复杂度 1
 *
 *  * 稳定性 : 不稳定
 *
 * @author zlj
 * @create 2022-07-18-15:47
 */
public class MergeSort {
    //归并排序,递归
    public void mergeSortByRecursion(int[] nums){
        mergeSortInsert(nums, 0, nums.length - 1);
    }
    //在区间 start end进行排序
    public void mergeSortInsert(int[] nums, int start, int end){
        if (end <= start){
            return;
        }
        int mid = (start + end) / 2;
        mergeSortInsert(nums, start, mid);
        mergeSortInsert(nums, mid + 1, end);
        merge(nums, start, end, mid);
    }

    //合并两个子序列
    public void merge(int[] nums, int start, int end, int mid){
        int[] arr = new int[end - start + 1];
        //左区间的指针
        int left = start;
        int right  = mid + 1;
        int i = 0;
        while (left <= mid && right <= end){
            if (nums[left] > nums[right]){
                arr[i++] = nums[right++];
            }else {
                arr[i++] = nums[left++];
            }
        }
        while (left <= mid && i <= end - start){
            arr[i++] = nums[left++];
        }
        while (right <= end && i <= end - start){
            arr[i++] = nums[right++];
        }
        i = 0;
        while (start <= end && i <arr.length){
            nums[start++] = arr[i++];
        }
    }

    //非递归
    public void mergeSort(int[] nums){
        //最外层表示每次合并子数组的元素个数
        for (int sz = 1; sz <= nums.length; sz += sz){
            //内层循环表示每个小区间元素排序
            for (int i = 0; i + sz < nums.length; i += sz + sz){
                merge(nums, i, Math.min(i + sz + sz - 1, nums.length - 1),i + sz - 1);
            }
        }
    }

    @Test
    public void test(){
        int[] arr = {2, 1, 4, 6, 3, 7, 9, 0};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr1 = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        mergeSort(arr1);

        System.out.println(Arrays.toString(arr1));
    }
}
