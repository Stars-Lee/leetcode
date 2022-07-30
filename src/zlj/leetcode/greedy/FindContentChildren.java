package zlj.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zlj
 * @create 2022-06-17-15:33
 */
public class FindContentChildren {
    public static void main(String[] args) {

    }
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        while (i < g.length && j < s.length){
            if (s[j] >= g[i]){
                j++;
                i++;
            }else{
                j++;
            }
        }
        return i;
    }
}
