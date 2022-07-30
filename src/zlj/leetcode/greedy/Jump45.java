package zlj.leetcode.greedy;

import com.sun.org.apache.xerces.internal.impl.dv.dtd.NMTOKENDatatypeValidator;
import org.junit.Test;

/**
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 示例 2:
 *
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 *  
 *
 * 提示:
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 *
 * @author zlj
 * @create 2022-06-27-14:49
 */
public class Jump45 {
    @Test
    public void test(){
        int[] nums = {1,2,3};
        System.out.println(jump1(nums));
    }
    public int jump(int[] nums) {
        int len = nums.length;
        int[] minJump = new int[len];
        for (int i = 0; i < len; i++){
            minJump[i] = len;
        }
        minJump[0] = 0;
        for (int i = 0; i < len; i++){
            for (int j = i + 1; j <= nums[i] + i && j < len; j++){
                minJump[j] = Math.min(minJump[j], minJump[i]+1);
            }
        }
        return minJump[len-1];
    }

    //顺藤摸瓜
    public int jump1(int[] nums) {
        //每次起跳的起点位置
        int start = 0;
        //每次跳跃的起点最终位置
        int maxPos = 1;
        //每次跳跃的最远位置
        int end = 0;

        int res = 0;
        while (end < nums.length - 1){
            for (int i = start; i < maxPos; i++){
                end = Math.max(end, nums[i] + i);
            }
            start = maxPos;
            maxPos = end + 1;
            res++;
        }
        return res;
    }
    public int jump2(int[] nums) {

        //每次跳跃的最远距离
        int maxPos = 1;
        //每次跳跃的最终位置
        int end = 0;

        int res = 0;
        for (int i = 0; i < nums.length - 1; i++){
            maxPos = Math.max(maxPos, nums[i] + i);
            if (i == end){
                end = maxPos + 1;
                res++;
            }
        }
        return res;
    }
}
