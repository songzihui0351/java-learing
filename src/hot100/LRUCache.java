package hot100;

import java.util.HashMap;

public class LRUCache {

    HashMap<Integer, DoubleLinkedNode> cache = new HashMap<>();
    DoubleLinkedNode head = new DoubleLinkedNode();
    DoubleLinkedNode tail = new DoubleLinkedNode();
    int capacity, size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
        size = 0;
    }

    public int get(int key) {
        DoubleLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        DoubleLinkedNode node = cache.get(key);
        if (node == null) {
            node = new DoubleLinkedNode(key, value);
            addToHead(node);
            cache.put(key, node);
            size++;
        } else {
            node.val = value;
            moveToHead(node);
        }
        if (size > capacity) {
            DoubleLinkedNode removedNode = removeTail();
            cache.remove(removedNode.key);
            size--;
        }
    }

    private DoubleLinkedNode removeTail() {
        DoubleLinkedNode node = tail.pre;
        removeNode(node);
        return node;
    }

    private void addToHead(DoubleLinkedNode node) {
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }

    private void moveToHead(DoubleLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(DoubleLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
}
