package 链表.排序链表;

import common.ListNode;

public class SortList_148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        // 1. 快慢指针找中点
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 2. 拆分成两个链表
        ListNode mid = slow.next; // mid是右半部分的第一个节点
        slow.next = null; // slow是左半部分的最后一个节点
        // 3. 递归排序
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
