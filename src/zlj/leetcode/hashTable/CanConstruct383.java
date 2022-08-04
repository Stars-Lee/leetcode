package zlj.leetcode.hashTable;

import org.junit.Test;

/**
 * @author: zlj
 * @date: 2022-08-01  10: 58 :10
 * @des:
 */
public class CanConstruct383 {
    @Test
    public void test() {
        String ransomNote = "a";
        String magazine = "b";
        System.out.println(canConstruct(ransomNote, magazine));

        ransomNote = "aa";
        magazine = "ab";
        System.out.println(canConstruct(ransomNote, magazine));

        ransomNote = "aa";
        magazine = "aab";
        System.out.println(canConstruct(ransomNote, magazine));
    }
    //数组
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] record = new int[26];
        for (char c : magazine.toCharArray()) {
            record[c - 'a'] += 1;
        }

        for (char c : ransomNote.toCharArray()) {
            record[c - 'a'] -= 1;
        }
        for (int i : record) {
            if (i < 0){
                return false;
            }
        }
        return true;
    }
}
