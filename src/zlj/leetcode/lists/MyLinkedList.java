package zlj.leetcode.lists;

/**
 * @author: zlj
 * @date: 2022/7/31 - 17:25
 * @desc: leetcode 707单链表
 */
public class MyLinkedList {
    int size;
    ListNode head;
    public MyLinkedList() {
        size = 0;
        //虚拟头节点
        head = new ListNode(0);
    }

    public int get(int index) {
        if (index < 0 || index >= size){
            return -1;
        }
        ListNode pre = head;
        for (int i = 0; i <= index; i++){
            pre = pre.next;
        }
        return pre.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size){
            return;
        }
        if (index < 0){
            index = 0;
        }
        size++;
        ListNode pre = head;
        for (int i = 0; i < index; i++){
            pre = pre.next;
        }
        ListNode cur = new ListNode(val);
        cur.next = pre.next;
        pre.next = cur;
    }

    public void deleteAtIndex(int index) {
        if (index >= size || index < 0){
            return;
        }
        size--;
        ListNode pre = head;
        for (int i = 0; i < index; i++){
            pre = pre.next;
        }
        pre.next = pre.next.next;
    }
}
