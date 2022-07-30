package zlj.leetcode.dp;

import org.junit.Test;

/**
 * @author zlj
 * @create 2022-07-13-15:35
 */
public class FindMaxForm474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] strArray = new int[len][2];
        for (int i = 0; i < len; i++) {
            char[] chars = strs[i].toCharArray();
            for (char aChar : chars) {
                if (aChar == '0'){
                    strArray[i][0]++;
                }else {
                    strArray[i][1]++;
                }
            }
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int item = 0; item < len; item++){
            for (int i = m; i >= strArray[item][0]; i--){
                for (int j = n; j >= strArray[item][1]; j--){
                    dp[i][j] = Math.max(dp[i][j], dp[i - strArray[item][0]][j - strArray[item][1]] + 1);
                }
            }
        }
        return dp[m][n];
    }

    //简化
    public int findMaxForm2(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int zeroNum = 0;
            int oneNum = 0;
            for (char aChar : str.toCharArray()) {
                if (aChar == '0'){
                    zeroNum++;
                }else {
                    oneNum++;
                }
            }
            for (int i = m; i >= zeroNum; i--){
                for (int j = n; j >= oneNum; j--){
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }

        return dp[m][n];
    }

    @Test
    public void test(){
        String[] str = {"10", "0001", "111001", "1", "0"};
        System.out.println(findMaxForm(str, 5, 3));

        String[] str1 = {"10", "0", "1"};
        System.out.println(findMaxForm(str1, 1, 1));
    }
}
