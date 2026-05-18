package mao.yannan._0146_lru_cache;

import java.util.HashMap;
import java.util.Map;

// @FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
class LRUCache {

    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        var node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        var node = map.get(key);
        if (node != null) {
            node.value = value;
            moveToFront(node);
            return;
        }
        if (map.size() == capacity) {
            var leastRecentlyUsed = tail.prev;
            remove(leastRecentlyUsed);
            map.remove(leastRecentlyUsed.key);
        }
        var fresh = new Node(key, value);
        map.put(key, fresh);
        addToFront(fresh);
    }

    private void moveToFront(Node node) {
        remove(node);
        addToFront(node);
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    // @FieldDefaults(level = AccessLevel.PRIVATE)
    private static final class Node {

        private final int key;
        private int value;
        private Node prev;
        private Node next;

        private Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }
}
