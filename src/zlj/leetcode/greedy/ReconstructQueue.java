package zlj.leetcode.greedy;

import org.junit.Test;
import java.util.*;

/**
 * @author zlj
 * @create 2022-06-20-17:13
 */
public class ReconstructQueue {
    @Test
    public void test(){
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
    }
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]){
                    return o2[0] - o1[0];
                }else {
                    return o1[1] - o2[1];
                }
            }
        });

        LinkedList<int[]> resTem = new LinkedList<>();
        for (int i = 0; i < people.length; i++){
            if (resTem.size() > people[i][1]){
                resTem.add(people[i][1], people[i]);
            }else {
                resTem.addLast(people[i]);
            }
        }
        return resTem.toArray(new int[people.length][2]);
    }
}

