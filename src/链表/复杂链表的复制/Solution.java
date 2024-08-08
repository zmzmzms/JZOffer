package 链表.复杂链表的复制;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public RandomListNode Clone(RandomListNode pHead) {
        RandomListNode dummy = new RandomListNode(-1);
        HashMap<RandomListNode, RandomListNode> maps = new HashMap<>();
        RandomListNode pre = dummy;
        RandomListNode cur = pHead;
        while (cur != null) {
            RandomListNode clone = new RandomListNode(cur.label);
            maps.put(cur, clone);
            pre.next = clone;
            pre = pre.next;
            cur = cur.next;
        }
        cur = dummy.next;
        for (Map.Entry<RandomListNode,RandomListNode> entry: maps.entrySet()) {
            if (entry.getKey().random != null) {
                entry.getValue().random = entry.getKey().random;
            }else {
                entry.getValue().random = null;
            }
        }
        return dummy.next;
    }


}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
