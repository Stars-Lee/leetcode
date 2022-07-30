package zlj.leetcode.greedy;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zlj
 * @create 2022-07-06-17:22
 */
public class FindMinArrowShots452 {
    public int findMinArrowShots(int[][] points) {
        int len = points.length;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] > 0 && b[1] < 0){
                    return 1;
                }
                if (a[1] < 0 && b[1] > 0){
                    return -1;
                }
                return a[1] - b[1];
            }
        });
        int res = 0;
        int end;
        int i = 0;
        while (i < len){
            int j = i + 1;
            end = points[i][1];
            while (j < len && points[j][0] <= end){
                j++;
            }
            res++;
            i = j;
        }
        return res;
    }

    public int findMinArrowShots1(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] > b[1]){
                    return 1;
                }
                else if (a[1] < b[1]){
                    return -1;
                }
                return 0;
            }
        });
        int res = 1;
        int end = points[0][1];
        for (int[] point : points) {
            if (point[0] > end){
                res++;
                end = point[1];
            }
        }
        return res;
    }
    @Test
    public void test(){
        int[][] points = {{-2147483646,-2147483645},
                {2147483646,2147483647}};
        System.out.println(findMinArrowShots(points));
    }
    @Test
    public void test2(){
        int[] nums = {2147483647, -2147483647};
        Arrays.sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
