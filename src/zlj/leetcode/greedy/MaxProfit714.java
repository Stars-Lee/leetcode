package zlj.leetcode.greedy;

/**
 * @author zlj
 * @create 2022-07-07-20:53
 */
public class MaxProfit714 {

    //动态规划
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]-fee);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[len-1][0];
    }

    //贪心
    public int maxProfit1(int[] prices, int fee) {
        int len = prices.length;
        int buy = prices[0] + fee;
        int profit = 0;
        for (int i = 1; i < len; i++){
            if (prices[i] + fee < buy){
                buy = prices[i] + fee;
            }else if (prices[i] > buy){
                profit += prices[i] - buy;
                buy = prices[i];
            }
        }
        return profit;
    }
}
