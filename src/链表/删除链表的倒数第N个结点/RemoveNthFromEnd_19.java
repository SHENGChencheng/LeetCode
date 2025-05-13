package 链表.删除链表的倒数第N个结点;

import common.ListNode;

public class RemoveNthFromEnd_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        // 要删除的节点的前一个节点 + n + 1 = null;
        // 所以先让 fast 走 n + 1 步,
        // 这样 fast 走到 null， slow 就会停在要删除的节点的前一个节点
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
