package zlj.leetcode.greedy;

import zlj.leetcode.commen.TreeNode;

/**
 * 可以说有如下三种：
 *
 * 该节点无覆盖
 * 本节点有摄像头
 * 本节点有覆盖
 * 我们分别有三个数字来表示：
 *
 * 0：该节点无覆盖
 * 1：本节点有摄像头
 * 2：本节点有覆盖
 *
 * @author zlj
 * @create 2022-07-08-11:08
 */
public class MinCameraCover968 {
    int result;
    public int minCameraCover(TreeNode root) {
        result = 0;
        if (traversal(root) == 0){
            result++;
        }
        return result;
    }

    int traversal(TreeNode root){
        if (root == null){
            return 2;
        }
        int left = traversal(root.left);
        int right = traversal(root.right);

        if (left == 2 && right == 2){
            return 0;
        }
        if (left == 0 || right == 0){
            result++;
            return 1;
        }

        if (left == 1 || right == 1){
            return 2;
        }
        return -1;
    }
}
