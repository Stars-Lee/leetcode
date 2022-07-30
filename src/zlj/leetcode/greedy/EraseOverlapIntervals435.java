package zlj.leetcode.greedy;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zlj
 * @create 2022-07-06-20:45
 */
public class EraseOverlapIntervals435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] != b[1]){
                    return a[1] - b[1];
                }

                return a[0] - b[0];
            }
        });

        int right = intervals[0][1];
        int res = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < right){
                res++;
            }else {
                right = intervals[i][1];
            }
        }
        return res;
    }

    //public int eraseOverlapIntervals1(int[][] intervals) {
    //}
    @Test
    public void test(){
        int[][] nums = {{1,2},
                {2,3}};
        System.out.println(eraseOverlapIntervals(nums));
    }
}
