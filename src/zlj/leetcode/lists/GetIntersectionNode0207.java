package zlj.leetcode.lists;

/**
 * @author: zlj
 * @date: 2022/7/31 - 22:13
 * @desc: 链表相交
 */
public class GetIntersectionNode0207 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headB == null || headA == null){
            return null;
        }
        int sizeA = 0;
        int sizeB = 0;
        ListNode preA = headA;
        ListNode preB = headB;
        while (preA != null){
            sizeA++;
            preA = preA.next;
        }
        while (preB != null){
            sizeB++;
            preB = preB.next;
        }
        preA = headA;
        preB = headB;
        while (preA != preB){
            if (sizeB > sizeA){
                preB = preB.next;
                sizeB--;
            }else if (sizeB < sizeA){
                preA = preA.next;
                sizeA--;
            }else {
                preB = preB.next;
                preA = preA.next;
                sizeB--;
                sizeA--;
            }
        }
        return preB;
    }
}
