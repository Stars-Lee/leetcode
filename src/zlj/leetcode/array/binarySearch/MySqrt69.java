package zlj.leetcode.array.binarySearch;

import org.junit.Test;

/**
 * @author: zlj
 * @date: 2022-07-25  20: 07 :11
 * @des:
 */
public class MySqrt69 {
    public int mySqrt(int x) {
        if (x == 0 || x == 1){
            return x;
        }
        int left = 1;
        int right = x / 2;
        int res = 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if ((long)mid * mid > x){
                right = mid - 1;
            }else {
                left = mid + 1;
                res = mid;
            }
        }
        return res;
    }
    @Test
    public void test(){
        System.out.println(mySqrt(2147395599));
    }
}
