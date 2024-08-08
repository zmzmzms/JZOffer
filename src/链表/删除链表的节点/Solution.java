package 链表.删除链表的节点;

import 链表.ListNode;

public class Solution {
    public ListNode deleteNode (ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
                break;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
