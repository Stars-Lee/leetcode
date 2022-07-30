package zlj.leetcode.dp;

import org.junit.Test;

/**
 * @author zlj
 * @create 2022-07-11-9:57
 */
public class MinCostClimbingStairs746 {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        //从第i点起跳的最少费用
        int[] dp = new int[len];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i= 2; i<len; i++){
            dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];
        }
        return Math.min(dp[len-1], dp[len-2]);
    }
    @Test
    public void test(){
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(minCostClimbingStairs(cost));
    }
}
