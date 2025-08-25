package 链表.LRU缓存;

import java.util.HashMap;

public class ExpiringLRUCache {
    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;
        long expireAt;

        public Node(int key, int value, long expireAt) {
            this.key = key;
            this.value = value;
            this.expireAt = expireAt;
        }
    }

    private Node dummy;
    private HashMap<Integer, Node> map;
    private int capacity;

    public ExpiringLRUCache(int capacity) {
        this.dummy = new Node(0, 0, Long.MAX_VALUE);
        this.dummy.prev = this.dummy;
        this.dummy.next = this.dummy;
        this.map = new HashMap<>();
        this.capacity = capacity;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void pushNode(Node node) {
        node.prev = dummy;
        node.next = dummy.next;
        dummy.next = node;
        dummy.next.prev = node;
    }

    private Node getNode(int key) {
        Node node = map.get(key);
        if (node == null) return null;
        if (System.currentTimeMillis() > node.expireAt) {
            removeNode(node);
            map.remove(key);
            return null;
        }
        removeNode(node);
        pushNode(node);
        return node;
    }

    public int get(int key) {
        Node node = getNode(key);
        return node == null ? -1 : node.value;
    }

    public void put(int key, int value, long ttlMillis) {
        Node node = getNode(key);
        if (node != null) {
            node.value = value;
            node.expireAt = System.currentTimeMillis() + ttlMillis;
            return;
        }
        Node newNode = new Node(key, value, System.currentTimeMillis() + ttlMillis);
        map.put(key, newNode);
        pushNode(newNode);
        if (map.size() > capacity) {
            Node toRemove = dummy.prev;
            removeNode(toRemove);
            map.remove(toRemove.key);
        }
    }
}
