package zlj.leetcode.greedy;


import java.util.HashSet;
import java.util.Set;

/**
 * @author zlj
 * @create 2022-06-20-14:31
 */
public class CanJump55 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
    }
    public boolean canJump(int[] nums) {
        Integer maxJump = 0;
        Set<Integer> set = new HashSet<>();
        set.add(0);
        for (int i = 0; i < nums.length; i++){
            if (maxJump >= nums.length-1){
                return true;
            }
            if (set.contains(i)){
                maxJump = Math.max(maxJump, i + nums[i]);
                for (int j = 0; j <= nums[i]; j++){
                    set.add(i + j);
                }
            }
        }
        return false;
    }

    public boolean canJump1(int[] nums){
        int max = 0;
        for (int i= 0; i < nums.length; i++){
            if (i <= max){
                max = Math.max(max, i+nums[i]);
            }
            if(max >= nums.length-1){
                return true;
            }
        }
        return false;
    }
}
