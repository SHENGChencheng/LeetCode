package 链表.删除排序链表中的重复元素2;

import common.ListNode;

public class DeleteDuplicates_82 {
    public ListNode deleteDuplicates_82(ListNode head) {
        if (head == null || head.next == null) {
            return head; // 空链表或单节点直接返回
        }
        ListNode dummy = new ListNode(-1); // 虚拟头节点
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            if (current.next.val == current.next.next.val) {
                int duplicateVal = current.next.val;
                // 跳过所有重复节点
                while (current.next != null && current.next.val == duplicateVal) {
                    current.next = current.next.next;
                }
            } else {
                current = current.next; // 无重复，移动 current
            }
        }
        return dummy.next;
    }
}
