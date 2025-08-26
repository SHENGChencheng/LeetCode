package 链表.反转链表;

import common.ListNode;

public class ReverseList_206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseListRecursive(ListNode head) {
        // 递归终止条件：当前节点为空或已经是最后一个节点
        if (head == null || head.next == null) {
            return head;
        }
        // 递归调用，反转以 head.next 开头的子链表
        // newHead 始终是原链表的尾节点，即新链表的头节点
        ListNode newHead = reverseListRecursive(head.next);
        // 回溯阶段：反转指针
        // 此时 head.next 是已反转子链表的尾节点
        // 让这个尾节点的 next 指向当前节点 head，完成反转
        head.next.next = head;
        // 防止形成环，将当前节点的 next 置为 null
        // (在后续的递归栈帧中，这个null又会被指向前一个节点)
        head.next = null;
        return newHead; // 始终返回新的头节点
    }
}
