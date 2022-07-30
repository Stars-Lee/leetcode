package zlj.leetcode.sort.standard;

import org.junit.Test;

import javax.naming.InsufficientResourcesException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 快速排序的基本思想：通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。
 *
 *  * 从待排序区间选择一个数，作为基准值(pivot)；
 *  * Partition: 遍历整个待排序区间，将比基准值小的（可以包含相等的）放到基准值的左边，将比基准值大的（可以包含相等的）放到基准值的右边；
 *  * 采用分治思想，对左右两个小区间按照同样的方式处理，直到小区间的长度 == 1，代表已经有序，或者小区间的长度 == 0，代表没有数据。
 *
 *  * 时间复杂度 nlogn
 *  *     最坏 n^2
 *  *     最好 nlogn
 *  * 空间复杂度 1
 *
 *  * 稳定性 : 不稳定
 *
 *
 * @author zlj
 * @create 2022-07-19-14:17
 */
public class QuickSort {
    //二路快排
    public void quickByTwoWay(int[] nums){
        quickSortInternal(nums, 0, nums.length - 1);
    }

    //递归
    private void quickSortInternal(int[] nums, int l, int r){
        if (l >= r){
            return;
        }
        int pivotIndex = partition(nums, l, r);
        quickSortInternal(nums, l, pivotIndex);
        quickSortInternal(nums, pivotIndex + 1, r);
    }

    //填坑法，移动元素，在区间[l....r]上快排
    private int partition(int[] nums, int left, int right){
        //取第一个位置元素为基准元素
        int pivot = nums[left];
        int pivotIndex = left;
        int l = left;
        int r = right;
        while (r > l){
            //r 指针从右向左遍历比较
            while (r > l){
                if (nums[r] <= pivot){
                    nums[pivotIndex] = nums[r];
                    pivotIndex = r;
                    l++;
                    break;
                }
                r--;
            }
            //从左向右比较遍历
            while (r > l){
                if (nums[l] > pivot){
                    nums[pivotIndex] = nums[l];
                    pivotIndex = l;
                    r--;
                    break;
                }
                l++;
            }
        }
        nums[pivotIndex] = pivot;
        return pivotIndex;
    }



    //交换
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void test(){
        int[] nums = {4, 7, 6, 5, 3, 2, 8, 1};
        QuickSortBySwap quickSortBySwap = new QuickSortBySwap();
        quickSortBySwap.quickSort(nums);
        System.out.println(Arrays.toString(nums));

        QuickSortByThreeWay quickSortByThreeWay = new QuickSortByThreeWay();
        quickSortByThreeWay.quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}

/**
 * 指针交换移动元素
 */
class QuickSortBySwap {
    public void quickSort(int[] nums){
        quickSortInternal(nums, 0, nums.length - 1);
    }

    public void quickSortInternal(int[] nums, int left, int right){
        if (left >= right){
            return;
        }
        int pivotIndex = partition(nums, left, right);
        quickSortInternal(nums, left, pivotIndex - 1);
        quickSortInternal(nums, pivotIndex + 1, right);
    }

    public int partition(int[] nums, int start, int end){
        int pivot = nums[start];
        int left = start;
        int right = end;
        while (left < right){
            //控制right指针比较并左移
            while (left < right && nums[right] > pivot) {
                right--;
            }
            //控制left指针比较并左移
            while (left < right && nums[left] <= pivot){
                left++;
            }
            //交换left和right指向的元素
            if (left < right){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
            }
        }
        //pivot和指针重合点交换
        int temp = nums[right];
        nums[right] = nums[start];
        nums[start] = temp;
        return right;
    }
}


//非递归
class QuickSortWithStack {
    public void quickSort(int[] nums){
        quickSortInternal(nums, 0, nums.length - 1);
    }

    public void quickSortInternal(int[] nums, int start, int end){
        // 用一个集合栈来代替递归的函数栈
        Stack<Map<String, Integer>> quickSortStack = new Stack<>();
        Map<String, Integer> rootMap = new HashMap<>();
        rootMap.put("start", start);
        rootMap.put("end", end);
        quickSortStack.push(rootMap);
        while (!quickSortStack.isEmpty()){
            Map<String, Integer> param = quickSortStack.pop();
            //得到基准元素位置
            int pivotIndex = partition(nums, param.get("start"), param.get("end"));
            if (param.get("start") < pivotIndex - 1){
                Map<String, Integer> leftParam = new HashMap<>();
                leftParam.put("start", start);
                leftParam.put("end", pivotIndex - 1);
                quickSortStack.push(leftParam);
            }
            if (end > pivotIndex + 1) {
                Map<String, Integer> rightParam = new HashMap<>();
                rightParam.put("start", pivotIndex + 1);
                rightParam.put("end", end);
                quickSortStack.push(rightParam);
            }
        }
    }
    public int partition(int[] nums, int start, int end){
        int pivot = nums[start];
        int left = start;
        int right = end;
        while (left < right){
            //控制right指针比较并左移
            while (left < right && nums[right] > pivot) {
                right--;
            }
            //控制left指针比较并左移
            while (left < right && nums[left] <= pivot){
                left++;
            }
            //交换left和right指向的元素
            if (left < right){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
            }
        }
        //pivot和指针重合点交换
        int temp = nums[right];
        nums[right] = nums[start];
        nums[start] = temp;
        return right;
    }
}


class QuickSortByThreeWay {

    public void quickSort(int[] nums){
        quickSortInternal(nums, 0, nums.length - 1);
    }

    public void quickSortInternal(int[] nums, int start, int end){
        if (start >= end){
            return;
        }
        int pivot = nums[start];
        //小于pivot的最右侧的index
        int smallR = start;
        //等于pivot的最
        int equalR = start;
        //大于基准值的最左侧元素下标bigL + 1
        int bigL = end;
        int i = equalR + 1;
        while (i < bigL){
            if (nums[i] == pivot){
                i++;
                equalR++;
            }else if (nums[i] > pivot){
                swap(nums, i, bigL);
                bigL--;
            }else {
                swap(nums, ++smallR, i++);
                equalR++;
            }
        }
        swap(nums, smallR, start);
        quickSortInternal(nums, start, smallR - 1);
        quickSortInternal(nums, equalR + 1, end);
    }


    //交换
    public void  swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

