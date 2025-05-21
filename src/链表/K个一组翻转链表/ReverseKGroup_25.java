package 链表.K个一组翻转链表;

import common.ListNode;

public class ReverseKGroup_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        ListNode node = head;
        for (int i = 0; i < k; i++) {
            if (node == null) return head; // 不足K个，不反转
            node = node.next;
        }
        // 翻转前k个节点
        ListNode prev = null;
        ListNode curr = head;
        for (int i = 0; i < k; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // 递归处理后续节点
        head.next = reverseKGroup(curr, k);
        return prev;
    }
}
