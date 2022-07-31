package zlj.leetcode.lists;

/**
 * @author: zlj
 * @date: 2022/7/31 - 22:27
 * @desc:
 */
public class DetectCycle142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){//有环
                ListNode index1 = fast;
                ListNode index2 = head;
                //两个指针，从头节点和相遇节点各走一步，知道相遇，相遇点即环入口
                while (index2 != index1){
                    index2 = index2.next;
                    index1 = index1.next;
                }
                return index1;
            }
        }
        return null;
    }
}
