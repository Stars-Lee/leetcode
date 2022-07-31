package zlj.leetcode.greedy;


/**
 * @author zlj
 * @create 2022-06-17-10:29
 */
public class DuplicateZeros {
    public static void main(String[] args) {
        int[] arr = {9,9,9,4,8,0,0,3,7,2,0,0,0,0,9,1,0,0,1,1,0,5,6,3,1,6,0,0,2,3,4,7,0,3,9,3,6,5,8,9,1,1,3,2,0,0,7,3,3,0,5,7,0,8,1,9,6,3,0,8,8,8,8,0,0,5,0,0,0,3,7,7,7,7,5,1,0,0,8,0,0};
        DuplicateZeros.solution(arr);
    }
    public static void solution(int[] arr){
        int len = arr.length;
        int i = 0;
        int top = 0;
        while (top < len){
            if (arr[i] == 0){
                top = top + 2;
            }else {
                top = top + 1;
            }
            i++;
        }

        if (top == len + 1){
            arr[len-1] = 0;
            top = len - 2;
            i--;
        }else {
            top--;
            i--;
        }

        while (top > i){
            if (arr[i] == 0){
                arr[top] = 0;
                arr[top-1] = 0;
                top = top - 2;
                i = i -2;
            }else {
                arr[top--] = arr[i--];
            }
        }
    }
}
