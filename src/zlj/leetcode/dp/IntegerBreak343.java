package zlj.leetcode.dp;

import org.junit.Test;


/**
 * @author zlj
 * @create 2022-07-11-15:07
 */
public class IntegerBreak343 {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        for (int i = 2; i <= n; i++){
            int curMax = 0;
            for (int j = 1; j < i; j++){
                curMax = Math.max(Math.max(dp[j], j) * (i - j), curMax);
            }
            dp[i] = curMax;
        }
        for (int i = 0; i <= n; i++){
            System.out.print(dp[i] + " ");
        }
        return dp[n];
    }
    //数学方法
    public int integerBreak1(int n) {
        if (n <= 3){
            return n-1;
        }
        int num_3 = n / 3;
        int reside = n % 3;
        if (reside == 0){
            return (int) Math.pow(3, num_3);
        }
        if (reside == 2){
            return (int) Math.pow(3, num_3) * 2;
        }
        return (int) Math.pow(3, num_3 - 1) * 2 * 2;
    }
    @Test
    public void test(){
        System.out.println(integerBreak1(10));
    }
}
