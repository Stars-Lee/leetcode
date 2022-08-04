package zlj.leetcode.hashTable;

import javax.naming.InsufficientResourcesException;
import java.util.HashMap;

/**
 * @author: zlj
 * @date: 2022-08-01  10: 12 :01
 * @des:
 */
public class IsAnagram242 {
    //hashmap
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> tmap = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            Integer count = smap.get(c);
            if (count == null){
                smap.put(c, 1);
            }else {
                smap.put(c, count + 1);
            }
        }

        for (int j = 0; j < t.length(); j++){
            Character c = t.charAt(j);
            Integer count = tmap.get(c);
            if (count == null){
                tmap.put(c, 1);
            }else{
                tmap.put(c, count + 1);
            }
        }

        for (Character c : smap.keySet()) {
            Integer snum = smap.get(c);
            Integer tnum = tmap.get(c);
            if (!snum.equals(tnum)){
                return false;
            }
        }
        return true;
    }
    //数组
    public boolean isAnagram(String s, String t) {
        int[] record = new int[26];
        for (char c : s.toCharArray()) {
            record[c - 'a'] += 1;
        }
        for (char c : t.toCharArray()) {
            record[c - 'a'] -= 1;
        }

        for (int i : record) {
            if (i != 0){
                return false;
            }
        }
        return true;
    }
}
