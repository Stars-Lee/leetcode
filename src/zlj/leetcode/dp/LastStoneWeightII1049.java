package zlj.leetcode.dp;

import org.junit.Test;

/**
 * @author zlj
 * @create 2022-07-13-9:40
 */
public class LastStoneWeightII1049 {
    //dp+二维数组
    public int lastStoneWeightII(int[] stones) {
        int len = stones.length;
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int target = sum / 2;
        int[][] dp = new int[len][target+1];
        for (int i = stones[0]; i <= target; i++){
            dp[0][i] = stones[0];
        }

        for (int i = 1; i < len; i++){
            for (int j = 0; j <= target; j++){
                if (stones[i] > j){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-stones[i]] + stones[i]);
                }
            }
        }

        return sum - dp[len-1][target] * 2;
    }

    //dp+滚动数组
    public int lastStoneWeightII2(int[] stones) {
        int len = stones.length;
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < len; i++){
            for (int j = target; j >= stones[i]; j--){
                dp[j] = Math.max(dp[j], dp[j-stones[i]] + stones[i]);
            }
        }
        return sum - dp[target] * 2;
    }

    @Test
    public void test(){
        int[] stones = {2,7,4,1,8,1};
        System.out.println(lastStoneWeightII2(stones));
    }
}
