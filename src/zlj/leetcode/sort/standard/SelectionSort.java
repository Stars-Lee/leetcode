package zlj.leetcode.sort.standard;

/**
 * 直接选择排序:
 *     每一次从无序区间选出最大（或最小）的一个元素，存放在无序区间的最后（或最前），直到全部待排序的数据元素排完 。
 * 每轮都找到一组数据中最小的数依次放在数组前面。
 *
 * 双向选择排序:
 *     每一次从无序区间选出最小 + 最大的元素，存放在无序区间的最前和最后，直到全部待排序的数据元素排完 。
 *
 *  * 时间复杂度 n^2
 *  *     最坏 n^2
 *  *     最好 n^2
 *  * 空间复杂度 1
 *  * 稳定型: 数组 不稳定  链表 稳定   eg: (6、7、6、2、8)
 *
 * * 与冒泡排序的不同：冒泡排序在找数的时候，每次比较都需要进行数据交换，而选择排序是两两对比 记录数据 的索引，找到数据后只进行一次交换。
 *
 * @author zlj
 * @create 2022-07-15-14:17
 */
public class SelectionSort {
    public int[] directSelect(int[] nums){
        int len = nums.length;
        for (int i = 0; i < len; i++){
            int min = i;
            for (int j = i + 1; j < len; j++){
                if (nums[min] > nums[j]){
                    min = j;
                }
            }
            int tem = nums[min];
            nums[min] = nums[i];
            nums[i] = tem;
        }
        return nums;
    }

    public int[] twoWaySelect(int[] nums){
        int len = nums.length;
        int low = 0;
        int high = len - 1;
        while (low < high){
            int min = low;
            int max = low;
            for (int i = low + 1; i <= high; i++){
                if (nums[min] > nums[i]){
                    min = i;
                }
                if (nums[max] < nums[i]){
                    max = i;
                }
            }
            int temp = nums[min];
            nums[min] = nums[low];
            nums[low++] = temp;
            temp = nums[max];
            nums[max] = nums[high];
            nums[high--] = temp;
        }
        return nums;
    }
}
