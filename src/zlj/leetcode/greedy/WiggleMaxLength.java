package zlj.leetcode.greedy;

import org.junit.Test;
import sun.misc.PostVMInitHook;
import sun.security.x509.IPAddressName;

import javax.xml.stream.FactoryConfigurationError;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/**
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列 。第一个差（如果存在的话）可能是正数或负数。仅有一个元素或者含两个不等元素的序列也视作摆动序列。
 *
 * 例如， [1, 7, 4, 9, 2, 5] 是一个 摆动序列 ，因为差值 (6, -3, 5, -7, 3) 是正负交替出现的。
 *
 * 相反，[1, 4, 7, 2, 5] 和 [1, 7, 4, 5, 5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 * 子序列 可以通过从原始序列中删除一些（也可以不删除）元素来获得，剩下的元素保持其原始顺序。
 *
 * 给你一个整数数组 nums ，返回 nums 中作为 摆动序列 的 最长子序列的长度 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,7,4,9,2,5]
 * 输出：6
 * 解释：整个序列均为摆动序列，各元素之间的差值为 (6, -3, 5, -7, 3) 。
 * 示例 2：
 *
 * 输入：nums = [1,17,5,10,13,15,10,5,16,8]
 * 输出：7
 * 解释：这个序列包含几个长度为 7 摆动序列。
 * 其中一个是 [1, 17, 10, 13, 10, 16, 8] ，各元素之间的差值为 (16, -7, 3, -3, 6, -8) 。
 * 示例 3：
 *
 * 输入：nums = [1,2,3,4,5,6,7,8,9]
 * 输出：2
 *
 * @author zlj
 * @create 2022-06-20-17:13
 */
public class WiggleMaxLength {
    @Test
    public void test(){

    }

    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        int[] up = new int[len];
        int[] down = new int[len];
        up[0] = down[0] = nums[0];
        for (int i = 1; i < len; i++){
            if (nums[i] > nums[i-1]){
                up[i] = down[i-1] + 1;
                down[i] = down[i -1];
            }else if (nums[i] < nums[i-1]){
                down[i] = up[i-1] + 1;
                up[i] = up[i-1];
            }else {
                down[i] = down[i -1];
                up[i] = up[i-1];
            }
        }
        return Math.max(up[len-1], down[len-1]);
    }

    public int wiggleMaxLength1(int[] nums) {
        int len = nums.length;
        //上升摆动序列和下降摆动序列替换为长度
        int up = 1, down = 1;;
        for (int i = 1; i < len; i++){
            if (nums[i] > nums[i-1]){
                up = Math.max(up, down + 1);
                down = down;
            }else if (nums[i] < nums[i-1]){
                down = Math.max(down, up + 1);
                up = up;
            }
        }
        return Math.max(up, down);
    }

    //贪心算法
    public int wiggleMaxLength2(int[] nums) {
        int len = nums.length;
        if (len <= 1){
            return len;
        }
        int preDiff = 0;
        int curDiff = 0;
        int susLen = 1;

        for (int i = 0; i < len - 1; i++){
            curDiff = nums[i+1] - nums[i];
            if (curDiff > 0 && preDiff <= 0 || (curDiff < 0 && preDiff >= 0)){
                susLen++;
                preDiff = curDiff;
            }
        }
        return susLen;
    }
}