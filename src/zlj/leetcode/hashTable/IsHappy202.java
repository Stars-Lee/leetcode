package zlj.leetcode.hashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: zlj
 * @date: 2022-08-02  13: 39 :15
 * @des:
 */
public class IsHappy202 {
    public boolean isHappy(int n) {
        Set<Integer> sumSet = new HashSet<>();
        while (n != 1 && !sumSet.contains(n)){
            sumSet.add(n);
            n = getNextNum(n);
        }
        return n == 1;
    }

    public int getNextNum(int n){
        int res = 0;
        while (n > 0){
            int tem = n % 10;
            res = res + tem * tem;
            n = n / 10;
        }
        return res;
    }
}
