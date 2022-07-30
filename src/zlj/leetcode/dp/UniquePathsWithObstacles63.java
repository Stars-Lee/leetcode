package zlj.leetcode.dp;

import org.junit.Test;

/**
 * @author zlj
 * @create 2022-07-11-14:20
 */
public class UniquePathsWithObstacles63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        int i = 0;
        int j = 0;
        while (i < m && obstacleGrid[i][0] == 0){
            dp[i++][0] = 1;
        }
        while (i < m){
            dp[i++][0] = 0;
        }
        while (j < n && obstacleGrid[0][j] == 0){
            dp[0][j++] = 1;
        }
        while (j < n){
            dp[0][j++] = 0;
        }
        for (int ii = 1; ii < m; ii++){
            for (int jj = 1; jj < n; jj++){
                if (obstacleGrid[ii][jj] == 1){
                    dp[ii][jj] = 0;
                }else {
                    dp[ii][jj] = dp[ii-1][jj] + dp[ii][jj-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
    @Test
    public void test(){
        //int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        //System.out.println(uniquePathsWithObstacles(obstacleGrid));
        int[][] obstacleGrid1 = {{0,1},{0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid1));

    }
}
