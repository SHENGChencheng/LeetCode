package 链表.LRU缓存;

import java.util.HashMap;

public class LRUCache_146 {
    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final Node dummy;
    private final HashMap<Integer, Node> map;
    private final int capacity;

    public LRUCache_146(int capacity) {
        this.dummy = new Node(0, 0);
        this.dummy.next = dummy;
        this.dummy.prev = dummy;
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
        dummy.next.prev = node;
        dummy.next = node;
    }

    private Node getNode(int key) {
        if (!map.containsKey(key)) {
            return null;
        }
        Node node = map.get(key);
        removeNode(node);
        pushNode(node);
        return node;
    }

    public int get(int key) {
        Node node = getNode(key);
        return node != null ? node.value : -1;
    }

    public void put(int key, int value) {
        Node node = getNode(key);
        if (node != null) {
            node.value = value;
            return;
        }
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        pushNode(newNode);
        if (map.size() > capacity) {
            Node toRemove = dummy.prev;
            removeNode(toRemove);
            map.remove(toRemove.key);
        }
    }

    public static void main(String[] args) {
        LRUCache_146 cache = new LRUCache_146(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // 返回 1
        cache.put(3, 3);                  // 淘汰 key 2
        System.out.println(cache.get(2)); // 返回 -1
    }
}
