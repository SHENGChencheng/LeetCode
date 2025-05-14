package 链表.随机链表的复制;

import common.Node;

public class CopyRandomList_138 {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        // 1. 复制每个节点，插入原节点后
        Node cur = head;
        while (cur != null) {
            Node copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
            cur = copy.next;
        }
        // 2. 设置复制节点的random指针
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        // 3. 拆分链表
        cur = head;
        Node dummy = new Node(0);
        Node copyCur = dummy;
        while (cur != null) {
            Node next = cur.next.next;
            Node copy = cur.next;
            copyCur.next = copy;
            copyCur = copy;
            cur.next = next;
            cur = next;
        }
        return dummy.next;
    }
}
