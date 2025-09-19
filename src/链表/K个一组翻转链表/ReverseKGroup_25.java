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

    public ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null || k == 1) return head;
        ListNode node = head;
        int count = 0;
        while (node != null && count < k) {
            count++;
            node = node.next;
        }
        // 翻转前k个节点
        ListNode prev = null;
        ListNode curr = head;
        for (int i = 0; i < count; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // 递归处理后续节点
        head.next = reverseKGroup2(curr, k);
        return prev;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = build(nums);
        ReverseKGroup_25 reverseKGroup_25 = new ReverseKGroup_25();
        ListNode node = reverseKGroup_25.reverseKGroup2(head, 3);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    private static ListNode build(int[] nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode curr = head;
        for (int i = 1; i < nums.length; i++) {
            curr.next = new ListNode(nums[i]);
            curr = curr.next;
        }
        return head;
    }
}
