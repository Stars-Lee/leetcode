package zlj.leetcode.greedy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zlj
 * @create 2022-07-07-9:45
 */
public class PartitionLabels763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int len = s.length();
        char[] chars = s.toCharArray();
        Map<Character, Integer> lastIndexMap = new HashMap<>();
        for (int i = 0; i < len; i++){
            lastIndexMap.put(chars[i], i);
        }

        int start = 0;
        int end = lastIndexMap.get(chars[start]);
        for (int i = 0; i < len; i++){
            end = Math.max(lastIndexMap.get(chars[i]), end);
            if (i == end){
                res.add(end - start + 1);
                start = i + 1;
            }
        }

        return res;
    }
    @Test
    public void test(){
        String s = "eaaaabaaec";
        List<Integer> integers = partitionLabels(s);
        for (Integer partitionLabel : integers) {
            System.out.println(partitionLabel);
        }
    }
}
