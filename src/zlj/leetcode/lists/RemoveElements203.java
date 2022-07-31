package zlj.leetcode.lists;

import org.junit.Test;

/**
 * @author: zlj
 * @date: 2022/7/31 - 16:51
 * @desc:
 */
public class RemoveElements203 {
    @Test
    public void test() {
        int[] nums = {1,2,6,3,4,5,6};
        ListNode.getLinkedList(nums);
    }
    public ListNode removeElements1(ListNode head, int val) {
        //确保第一个节点的值非目标值
        while (head != null && head.val == val){
            head = head.next;
        }
        if (head == null){
            return head;
        }
        ListNode pre = head;
        ListNode cur =  head.next;
        while (cur != null){
            if (cur.val == val){
                pre.next = cur.next;
                cur = pre.next;
            }else {
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }

    //设置虚拟头节点
    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return head;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null){
            if (cur.val == val){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
