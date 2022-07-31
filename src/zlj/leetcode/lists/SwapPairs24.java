package zlj.leetcode.lists;

/**
 * @author: zlj
 * @date: 2022/7/31 - 19:04
 * @desc:
 */
public class SwapPairs24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        //虚拟指针,指向以交换节点的最后一个节点
        ListNode pre = new ListNode(-1, head);
        ListNode first = head;
        head = head.next;
        ListNode second;
        while (first != null && first.next != null){
            second = first.next;
            //交换位置
            first.next = second.next;
            second.next = first;
            //已交换节点 连接本轮交换的两个节点，并移动位置
            pre.next = second;
            pre = first;
            //移动的节点
            first = first.next;
        }

        return head;
    }
}
