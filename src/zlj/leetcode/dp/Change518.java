package zlj.leetcode.dp;


import org.junit.Test;
import org.junit.runners.Parameterized;

import java.lang.reflect.Constructor;
import java.util.Arrays;

/**
 * @author zlj
 * @create 2022-07-13-16:34
 */
public class Change518 {
    //dp+二维数组
    public int change(int amount, int[] coins) {
        int len = coins.length;
        int[][] dp = new int[len][amount + 1];
        dp[0][0] = 1;
        for (int j = 1; j <= amount; j++){
            if (j % coins[0] == 0){
                dp[0][j] = 1;
            }else {
                dp[0][j] = 0;
            }
        }

        for (int i = 1; i < len; i++){
            for (int j = 0; j <= amount; j++){
                if (j < coins[i]){
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]];
                }
            }
        }
        return dp[len - 1][amount];
    }
    //dp+滚动数组
    public int change2(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int j = 1; j <= amount; j++){
            if (j % coins[0] == 0){
                dp[j] = 1;
            }else {
                dp[j] = 0;
            }
        }

        for (int i = 1; i < coins.length; i++){
            for (int j = coins[i]; j <= amount; j++){
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }

        return dp[amount];
    }


    @Test
    public void test(){
        int[] coins = {1, 2, 5};
        System.out.println(change2(5, coins));

        int[] coins1 = {2};
        System.out.println(change2(3, coins1));

        int[] coins2 = {10};
        System.out.println(change2(10, coins2));
    }
}
