package zlj.leetcode.dp;

import org.junit.Test;

/**
 * @author zlj
 * @create 2022-07-12-10:54
 */
public class NumTrees96 {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[0] = 1;
        for (int  i = 2; i <= n; i++){
            int sum = 0;
            for (int j = 1; j <= i; j++){
                //根节点为j,左子树节点个数为j-1; 右子树节点个数为i-j;
                sum += dp[j-1] * dp[i-j];
            }
            dp[i] = sum;
        }
        return dp[n];
    }
    //递归
    public int numTrees1(int n) {
        if (n <= 1){
            return 1;
        }
        return reverse(n);
    }

    public int reverse(int n){
        if (n == 1){
           return 1;
        }
        if (n == 0){
            return 1;
        }
        int sum = 0;
        for (int i = 1; i <= n; i++){
            sum += reverse(i-1) * reverse(n-i);
        }
        return sum;
    }
    @Test
    public void test(){
        System.out.println(numTrees1(10));
        System.out.println(numTrees(10));
    }
}
