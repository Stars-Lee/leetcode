package zlj.leetcode.lists;

import org.junit.Test;

/**
 * @author: zlj
 * @date: 2022/7/31 - 21:42
 * @desc:
 */
public class RemoveNthFromEnd19 {
    @Test
    public void test() {
        int[] nums = {1,2,3,4,5};
        ListNode linkedList = ListNode.getLinkedList(nums);
        ListNode listNode = removeNthFromEnd(linkedList, 2);
        while (listNode != null){
            System.err.println(listNode.val);
            listNode = listNode.next;
        }

    }
    public ListNode removeNthFromEnd(ListNode head, int n){
        if (head == null || n <= 0){
            return head;
        }
        //删除最好使用虚拟头节点，便于统一删除头节点
        ListNode dummy =new ListNode(-1, head);
        //快慢指针
        ListNode fast = dummy;
        while (n > 0 && fast != null){
            fast = fast.next;
            n--;
        }
        if (head == null && n > 0){
            return head;
        }

        ListNode slow = dummy;
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
