package zlj.leetcode.greedy;

import org.junit.Test;


/**
 * @author zlj
 * @create 2022-07-07-19:36
 */
public class MonotoneIncreasingDigits738 {
    //从前向后遍历
    public int monotoneIncreasingDigits(int n) {
        char[] chars = Integer.toString(n).toCharArray();
        int len = chars.length;
        int i = 1;
        while (i < len  && chars[i] >= chars[i-1]){
            i++;
        }
        if (i < len){
            while (i > 0 && chars[i-1] > chars[i]){
                chars[i-1] -= 1;
                i--;
            }
            for (i += 1; i < len; ++i) {
                chars[i] = '9';
            }
        }
        return Integer.parseInt(new String(chars));
    }

    //从后向前遍历
    public int monotoneIncreasingDigits1(int n){
        char[] chars = Integer.toString(n).toCharArray();
        int res = 0;
        int len = chars.length;
        int start = len;//第一个9开始的下标
        for (int i = len -1; i > 0; i--){
            if (chars[i] < chars[i-1]){
                chars[i-1]--;
                start = i;
            }
        }
        for (int i = start; i < len; i++){
            chars[i] = '9';
        }
        return Integer.parseInt(new String(chars));
    }

    @Test
    public void test(){
        System.out.println(monotoneIncreasingDigits1(10));
        System.out.println(monotoneIncreasingDigits1(1234));
        System.out.println(monotoneIncreasingDigits1(332));
        System.out.println(monotoneIncreasingDigits1(0));
    }
}
