package zlj.leetcode.greedy;

import org.junit.Test;

import java.util.*;

/**
 * @author zlj
 * @create 2022-07-07-15:43
 */
public class Merge56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] <= end){
                end = Math.max(end, interval[1]);
            }
            if (interval[0] > end){
                list.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }
        list.add(new int[]{start, end});
        int[][] res = new int[list.size()][2];
        int index = 0;
        for (int[] ints : list) {
            res[index++] = ints;
        }
        return res;
    }
    @Test
    public void test(){
        int[][] nums = {{1,3},{2,6},{8,10},{15,18}};
        merge(nums);
    }
}
