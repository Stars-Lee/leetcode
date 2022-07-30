package zlj.leetcode.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: zlj
 * @date: 2022-07-29  11: 18 :35
 * @des:
 *
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：[[1]]
 *
 * 提示：
 * 1 <= n <= 20
 */
public class GenerateMatrix59 {
    @Test
    public void test() {
        for (int[] ints : generateMatrix(1)) {
            System.out.println(Arrays.toString(ints));
        }
    }
    public int[][] generateMatrix(int n) {
        if (n == 0){
            return new int[0][0];
        }

        int[][] matrix = new int[n][n];
        int wideS = 0;//横坐标起始的左指针
        int wideM = n - 1;//横坐标起始的右指针
        int highS = 0;
        int highM = n - 1;
        int no = 1;
        int vol;//垂直方向
        int col;//水平方向
        while (wideS <= wideM && highS <= highM){
            col = wideS;
            while (col <= wideM){
                matrix[highS][col++] = no++;
            }
            highS++;
            vol = highS;
            while (vol <= highM){
                matrix[vol++][wideM] = no++;
            }
            wideM--;
            col = wideM;
            while (col >= wideS){
                matrix[highM][col--] = no++;
            }
            highM--;
            vol = highM;
            while (highS <= vol){
                matrix[vol--][wideS] = no++;
            }
            wideS++;
        }
        return matrix;
    }
}
