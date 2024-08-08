package 链表.删除链表中重复的结点;

import 链表.ListNode;

public class Solution {
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode dummy = new ListNode(-1);
        dummy.next = pHead;
        ListNode curr = dummy;
        while (curr.next != null && curr.next.next != null) {
            if (curr.next.val == curr.next.next.val) {
                int temp = curr.next.val;
                while (curr.next != null && curr.next.val == temp) {
                    curr.next = curr.next.next;
                }
            }else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
