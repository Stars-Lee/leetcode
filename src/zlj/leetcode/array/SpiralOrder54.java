package zlj.leetcode.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: zlj
 * @date: 2022-07-29  14: 44 :45
 * @des:
 *
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */
public class SpiralOrder54 {
    @Test
    public void test() {
        int[][] nums = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(Arrays.toString(spiralOrder(nums).toArray()));

    }
    public List<Integer> spiralOrder(int[][] matrix) {
        int high = matrix.length;
        if (high == 0){
            return new ArrayList<Integer>();
        }
        int wide = matrix[0].length;
        if (wide == 0){
            return new ArrayList<>();
        }
        //边界
        int left = 0;
        int right = wide - 1;
        int top = 0;
        int tail = high - 1;
        //移动指针
        int vol;//垂直
        int col;//水平
        List<Integer> list = new ArrayList<>(high * wide);
        while (left <= right && top <= tail){
            col = left;
            while (col <= right){
                list.add(matrix[top][col++]);
            }
            top++;
            vol = top;
            if (vol > tail) break;
            while (vol <= tail){
                list.add(matrix[vol++][right]);
            }
            right--;
            col = right;
            if (col < left) break;
            while (col >= left){
                list.add(matrix[tail][col--]);
            }
            tail--;
            vol = tail;
            if (vol < top) break;
            while (vol >= top){
                list.add(matrix[vol--][left]);
            }
            left++;
        }
        return list;
    }
}
