package zlj.leetcode.lists;

/**
 * @author: zlj
 * @date: 2022/7/31 - 17:59
 * @desc:
 */
public class ReverseList206 {
    //头节点 + 双指针
    public ListNode reverseList1(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            pre.next = cur.next;
            cur.next = head;
            head = cur;
            cur = pre.next;
        }
        return head;
    }
    //虚拟指针 + 双指针
    public ListNode reverseList2(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode pre = new ListNode(-1, null);
        ListNode cur = head;
        while (cur != null){
            head = head.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = head;
        }
        return pre.next;
    }
    //递归
    public ListNode reverseList(ListNode head) {
        //反转后 未反转
        return reverse(null, head);
    }
    public ListNode reverse(ListNode pre, ListNode head){
        if (head == null){
            return pre;
        }
        ListNode tem = head.next;
        head.next = pre;
        return reverse(head, tem);
    }

}
