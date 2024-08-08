package 链表.回文链表;

import 链表.ListNode;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            if (list.get(l) != list.get(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
