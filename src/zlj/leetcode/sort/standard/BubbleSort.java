package zlj.leetcode.sort.standard;

/**
 * 升序
 * 原理: 在无序区间，通过相邻数的比较，将最大的数冒泡到无序区间的最后，持续这个过程，直到数组整体有序
 *
 *  * 时间复杂度 n^2
 *  *     最坏 n^2
 *  *     最好 n
 *  * 空间复杂度 1
 *  * 稳定型: 稳定
 *
 * @author zlj
 * @create 2022-07-15-11:42
 */

public class BubbleSort {
    public int[] bubbleSort(int[] nums){
        int len = nums.length;
        if (len < 2){
            return nums;
        }
        for (int i = 0;  i < len; i++){
            for (int j = 0; j < len - 1 - i; j++){
                if (nums[j] > nums[j + 1]){
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }
}
