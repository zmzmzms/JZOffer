package 链表.LRU缓存;

import java.util.HashMap;

public class LRUCache {
    public class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key,int value) {
            this.key = key;
            this.value = value;
        }
    }
    HashMap<Integer, Node> map;
    Node left;
    Node right;
    int capacity;
    int length;

    public LRUCache(int capacity) {
        this.left = new Node(-1, -1);
        this.right = new Node(-1, -1);
        left.prev = null;
        left.next = right;
        right.prev = left;
        right.next = null;
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.length = 0;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node target = map.get(key);
            remove(target);
            insertFromRight(target);
            return target.value;
        }else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            remove(node);
            insertFromRight(node);
        }else {
            Node target = new Node(key, value);
            if (length < capacity) {
                insertFromRight(target);
                map.put(key, target);
                length++;
            }else {
                Node oldest = left.next;
                remove(oldest);
                map.remove(oldest.key);
                insertFromRight(target);
                map.put(key, target);
            }
        }
    }

    public void remove(Node target) {
        target.next.prev = target.prev;
        target.prev.next = target.next;
    }

    public void insertFromRight(Node target) {
        target.prev = right.prev;
        target.next = right;
        right.prev.next = target;
        right.prev = target;
    }

}
