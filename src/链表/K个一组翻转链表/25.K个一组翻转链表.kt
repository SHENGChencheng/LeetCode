package 链表.K个一组翻转链表

import common.ListNode

class ReverseKGroup {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        if (head == null || k == 1) return head
        var node = head
        for (i in 0 until k) {
            if (node == null) return head
            node = node.next
        }
        var prev: ListNode? = null
        var curr = head
        for (i in 0 until k) {
            val next = curr?.next
            curr?.next = prev
            prev = curr
            curr = next
        }
        head.next = reverseKGroup(curr, k)
        return prev
    }
}