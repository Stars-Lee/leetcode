package zlj.leetcode.lists;

import zlj.leetcode.greedy.LemonadeChange860;

/**
 * @author: zlj
 * @date: 2022/7/31 - 16:55
 * @desc:
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    /**
     * 将数组初始化为链表
     * @param nums
     * @return
     */
    public static ListNode getLinkedList(int[] nums){
        if (nums.length == 0){
            return null;
        }
        ListNode head = new ListNode(nums[0]);
        ListNode pre = head;
        for (int i = 1; i < nums.length; i++){
            pre.next = new ListNode(nums[i]);
            pre = pre.next;
        }
        return head;
    }

}
