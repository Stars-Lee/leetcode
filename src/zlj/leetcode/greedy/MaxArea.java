package zlj.leetcode.greedy;

/**
 * @author zlj
 * @create 2022-06-20-10:44
 */
public class MaxArea {
    public static void main(String[] args) {
    }

    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left <= right){
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if (height[left] >= height[right]){
                right--;
            }else {
                left++;
            }
        }
        return max;
    }
}
