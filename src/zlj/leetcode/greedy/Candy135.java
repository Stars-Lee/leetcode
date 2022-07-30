package zlj.leetcode.greedy;

import jdk.nashorn.internal.runtime.Context;
import org.junit.Test;

import java.security.interfaces.RSAKey;

/**
 * @author zlj
 * @create 2022-07-04-14:23
 */
public class Candy135 {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] candy = new int[len];
        int i;
        for (i = 1; i < len; i++){
            if (ratings[i] > ratings[i-1]){
                break;
            }
        }
        candy[i-1] = 1;
        for (int j = i-2; j >= 0; j--){
            if (ratings[j] == ratings[j+1]){
                candy[j] = 1;
            }else if (ratings[j] > ratings[j+1]){
                candy[j] = candy[j+1]+1;
            }
        }
        int j= i;
        while (j < len){
            int up = j;
            while (up < len){
                if (ratings[up] < ratings[up-1]){
                    break;
                }
                if (ratings[up] == ratings[up-1]){
                    candy[up] = 1;
                }else {
                    candy[up] = candy[up-1]+1;
                }
                up++;
            }
            if (up == len){
                break;
            }
            int down = up;
            while (down < len){
                if (ratings[down] > ratings[down-1]){
                    break;
                }
                down++;
            }
            j = down;
            candy[down-1] = 1;
            for (int n = down-2; n >= up; n--){
                if (ratings[n] == ratings[n+1]){
                    candy[n] = 1;
                }else if (ratings[n] > ratings[n+1]){
                    candy[n] = candy[n+1]+1;
                }
            }
            candy[up-1] = Math.max(candy[up-1], candy[up]+1);
            j = down;
        }
        int sum = 0;
        for (int z = 0; z < len; z++){
            sum = sum + candy[z];
        }
        return sum;
    }

    //两次遍历
    public int candy1(int[] ratings) {
        int len = ratings.length;
        int[] left = new int[len];
        for (int i = 0; i < len; i++){
            if (i > 0 && ratings[i] > ratings[i-1]){
                left[i] = left[i-1] + 1;
            }else {
                left[i] = 1;
            }
        }
        int right = 0, res = 0;
        for (int i = len - 1; i >= 0; i--){
            if (i < len - 1 && ratings[i] > ratings[i-1]){
                right++;
            }else {
                right = 1;
            }
            res = res + Math.max(left[i], right);
        }
        return res;
    }
    //一次遍历
    public int candy2(int[] ratings){
        int len = ratings.length;
        int des = 0;//递减序列长度（包括最大， 不包括最小）
        int res = 1;//结果
        int pre = 1;//前一个的糖果个数
        int top = 1; //上升序列最大的值
        for (int i = 1; i < len; i++){
            if (ratings[i] > ratings[i-1]){
                des = 0;
                pre++;
                top = pre;
                res += pre;
            }else if (ratings[i] == ratings[i-1]){
                des = 0;
                pre = 1;
                top = pre;
                res += pre;
            }else {
                des++;
                pre = 1;
                res = res + des;
                if (top <= des){
                    res = res+1;
                }
            }
        }
        return res;
    }
    //两次遍历分糖果，一次遍历求和
    public int candy3(int[] ratings){
        int len = ratings.length;
        int[] candy = new int[len];
        candy[0] = 1;
        for (int i = 1; i < len; i++){
            if (ratings[i] > ratings[i-1]){
                candy[i] = candy[i-1] + 1;
            }else {
                candy[i] = 1;
            }
        }
        //从后向前遍历
        for (int i = len - 2; i >= 0; i--){
            if (ratings[i] > ratings[i + 1]){
                candy[i] = Math.max(candy[i], candy[i+1]+1);
            }
        }

        int res = 0;
        for (int i = 0; i < len; i++){
            res = res + candy[i];
        }
        return res;
    }
    @Test
    public void test(){
        int[] rating = {1,0,2};
        System.out.println(candy3(rating));
    }
}
