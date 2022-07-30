package zlj.leetcode.array.binarySearch;

/**
 * @author: zlj
 * @date: 2022-07-26  15: 51 :16
 * @des:
 */
public class IsPerfectSquare367 {
    public boolean isPerfectSquare(int num) {
        if (num == 1){
            return true;
        }
        int left = 1;
        int right = num / 2;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if ((long)mid * mid > num){
                right = mid - 1;
            }else if ((long) mid * mid < num){
                left = mid + 1;
            }else {
                return true;
            }
        }
        return false;
    }
}
