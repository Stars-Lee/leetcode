package zlj.leetcode.array;

import org.junit.Test;

import java.util.Stack;
import java.util.WeakHashMap;

/**
 * @author: zlj
 * @date: 2022-07-27  13: 53 :30
 * @des:
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 *
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "ab#c", t = "ad#c"
 * 输出：true
 * 解释：s 和 t 都会变成 "ac"。
 * 示例 2：
 *
 * 输入：s = "ab##", t = "c#d#"
 * 输出：true
 * 解释：s 和 t 都会变成 ""。
 * 示例 3：
 *
 * 输入：s = "a#c", t = "b"
 * 输出：false
 * 解释：s 会变成 "c"，但 t 仍然是 "b"。
 *  
 *
 * 提示：
 *
 * 1 <= s.length, t.length <= 200
 * s 和 t 只含有小写字母以及字符 '#'
 *  
 *
 * 进阶：
 * 你可以用 O(n) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
 *
 */
public class BackspaceCompare844 {
    /**
     * 利用堆栈
     * @param s
     * @param t
     * @return
     */
    public boolean backspaceCompare1(String s, String t) {
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            if (c != '#'){
                sStack.push(c);
            }else if (!sStack.isEmpty()){
                sStack.pop();
            }
        }
        for (int i = 0; i < t.length(); i++){
            Character c = t.charAt(i);
            if (c != '#'){
                tStack.push(c);
            }else if (!tStack.isEmpty()){
                tStack.pop();
            }
        }
        while (!sStack.isEmpty() && !tStack.isEmpty()){
            Character sc = sStack.pop();
            Character tc = tStack.pop();
            if (sc != tc){
                return false;
            }
        }
        if (sStack.isEmpty() && tStack.isEmpty()){
            return true;
        }
        return false;
    }

    /**
     * 双指针
     * @param s
     * @param t
     * @return
     */
    public boolean backspaceCompare2(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        while (i >= 0 || j >= 0){
            //#个数
            int sCount = 0;
            while (i >= 0 && s.charAt(i) == '#'){
                while (i >= 0 && s.charAt(i) == '#'){
                    sCount++;
                    i--;
                }
                while (sCount > 0 && i >= 0 && s.charAt(i) != '#'){
                    i--;
                    sCount--;
                }
            }

            //#个数
            int tCount = 0;
            while (j >= 0 && t.charAt(j) == '#'){
                while (j >= 0 && t.charAt(j) == '#'){
                    tCount++;
                    j--;
                }
                while (tCount > 0 && j >= 0 && t.charAt(j) != '#'){
                    j--;
                    tCount--;
                }
            }
            if (j < 0 && i < 0){
                return true;
            }
            if (j < 0 || i < 0){
                return false;
            }
            if (s.charAt(i) != t.charAt(j)){
                return false;
            }
            i--;
            j--;
        }
        return true;
    }

    /**
     * 双指针优化
     * @param s
     * @param t
     * @return
     */
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int sSkip = 0;
        int tSkip = 0;
        while (i >= 0 || j >= 0){
            while (i >= 0){
                if (s.charAt(i) == '#'){
                    sSkip++;
                    i--;
                }else if (sSkip > 0){
                    sSkip--;
                    i--;
                }else {
                    break;
                }
            }

            while (j >= 0){
                if (t.charAt(j) == '#'){
                    tSkip++;
                    j--;
                }else if (tSkip > 0){
                    tSkip--;
                    j--;
                }else {
                    break;
                }
            }

            if (i < 0 && j < 0){
                return true;
            }
            if (i < 0 || j < 0){
                return false;
            }
            if (s.charAt(i) != t.charAt(j)){
                return false;
            }
            i--;
            j--;
        }
        return true;
    }

    @Test
    public void test(){
        String s = "ab#c";
        String t = "ad#c";
        System.out.println(backspaceCompare(s, t));

        s = "ab##";
        t = "c#d#";
        System.out.println(backspaceCompare(s, t));

        s = "a#c";
        t = "b";
        System.out.println(backspaceCompare(s, t));

        s = "bxj##tw";
        t = "bxo#j##tw";
        System.out.println(backspaceCompare(s, t));

        s = "xywrrmp";
        t = "xywrrmu#p";
        System.out.println(backspaceCompare(s, t));
    }
}
