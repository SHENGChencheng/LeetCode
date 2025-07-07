package 链表.合并K个升序链表;

import common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.length,
                Comparator.comparingInt((ListNode o) -> o.val));
        for (ListNode node : lists){
            if (node != null) {
                heap.offer(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            curr.next = node;
            curr = curr.next;
            if (node.next != null) {
                heap.offer(node.next);
            }
        }
        return dummy.next;
    }
}
